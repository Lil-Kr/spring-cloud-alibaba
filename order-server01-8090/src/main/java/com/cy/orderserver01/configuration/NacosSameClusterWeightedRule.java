package com.cy.orderserver01.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.google.common.collect.Lists;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: 烟幕
 * @Date: 2021/5/1
 * @Description:
 */
@Slf4j
public class NacosSameClusterWeightedRule extends AbstractLoadBalancerRule {

    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties1;


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        // 拿到配置中心的集群名称 GZ
        String clusterName = nacosDiscoveryProperties1.getClusterName();
        //
        BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
        // 需要请求的服务看名称
        String name = loadBalancer.getName();
        // 拿到服务发现的相关API
        NamingService namingService = nacosDiscoveryProperties1.namingServiceInstance();

        try {
            // 1. 找到指定服务的所有实例 A
            List<Instance> instances = namingService.selectInstances(name, true);

            // 2. 过滤出相同集群下的所有实例 B
            List<Instance> sameClusterInstances = instances.stream()
                    .filter(instance -> Objects.equals(instance.getClusterName(), clusterName))
                    .collect(Collectors.toList());

            // 3. 如果B是空, 就用A
            List<Instance> instancesToBeChosen = Lists.newArrayList();
            if (CollectionUtils.isEmpty(sameClusterInstances)) {
                instancesToBeChosen = instances;
                log.warn("发生了跨集群的调用, name={}, clusterName={}, instances={}",name,clusterName, JSONArray.toJSONString(instancesToBeChosen));
            }else {
                instancesToBeChosen = sameClusterInstances;
            }

            // 4. 基于权重的负载均衡算法, 返回1个实例
            Instance instance = ExtendBalancer.getHostByRandomWeight2(instances);
            log.info("选择的实例是: port={}, instance={}", instance.getPort(), JSONObject.toJSONString(instance));

            return new NacosServer(instance);
        } catch (NacosException e) {
            e.printStackTrace();
            log.error("发生异常了: {}",e);
            return null;
        }
    }
}

/**
 * 扩展算法
 */
class ExtendBalancer extends Balancer {

    public static Instance getHostByRandomWeight2(List<Instance> hosts) {
        return getHostByRandomWeight(hosts);
    }

}