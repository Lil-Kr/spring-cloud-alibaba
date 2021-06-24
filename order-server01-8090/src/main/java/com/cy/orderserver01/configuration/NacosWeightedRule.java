package com.cy.orderserver01.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @Author: 烟幕
 * @Date: 2021/5/1
 * @Description: 编写自己的负载均衡
 */
@Slf4j
public class NacosWeightedRule extends AbstractLoadBalancerRule {

    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties1;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        // 读取配置文件, 并初始化 NacosWeightedRule
    }

    @Override
    public Server choose(Object key) {
        // ribbon的入口
        BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
        log.info("lb:{}",JSONObject.toJSONString(loadBalancer));

        // 需要请求的服务看名称
        String name = loadBalancer.getName();
        log.info("name:{}", name);
        // 拿到服务发现的相关API
        NamingService namingService = nacosDiscoveryProperties1.namingServiceInstance();
        log.info("namingService:{}", JSONObject.toJSONString(namingService));

        try {
            // nacos client 自动通过基于权重的负载均衡算法, 选择一个实例
            Instance instance = namingService.selectOneHealthyInstance(name);
            log.info("instance:{}", JSONObject.toJSONString(instance));
            return new NacosServer(instance);
        } catch (NacosException e) {
            return null;
        }
    }
}