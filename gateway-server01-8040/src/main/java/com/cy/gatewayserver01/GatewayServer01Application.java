package com.cy.gatewayserver01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 烟幕
 * @Date: 2021/5/4
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServer01Application.class, args);
    }

}