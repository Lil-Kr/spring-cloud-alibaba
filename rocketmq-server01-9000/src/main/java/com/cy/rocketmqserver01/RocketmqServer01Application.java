package com.cy.rocketmqserver01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 烟幕
 * @Date: 2021/5/5
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RocketmqServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqServer01Application.class,args );
    }


}
