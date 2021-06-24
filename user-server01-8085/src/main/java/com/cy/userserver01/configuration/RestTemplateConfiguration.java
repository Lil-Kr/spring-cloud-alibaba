package com.cy.userserver01.configuration;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 烟幕
 * @Date: 2021/5/3
 * @Description:
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced
    @SentinelRestTemplate
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
