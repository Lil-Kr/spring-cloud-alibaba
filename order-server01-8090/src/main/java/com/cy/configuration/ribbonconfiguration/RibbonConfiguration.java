package com.cy.configuration.ribbonconfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 烟幕
 * @Date: 2021/5/1
 * @Description:
 */
@Configuration
public class RibbonConfiguration {

//    /**
//     * 获取LB自定规则: 随机
//     * @return
//     */
//    @Bean
//    public IRule getRandomRule() {
//        return new RandomRule();
//    }

    @Bean
    public IRule getLoadBalanceRule() {
//        return new NacosSameClusterWeightedRule();
//        return new NacosWeightedRule();
//        return new RandomRule();
        return new RoundRobinRule();
    }

}