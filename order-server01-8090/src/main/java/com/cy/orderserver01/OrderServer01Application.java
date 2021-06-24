package com.cy.orderserver01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 烟幕
 * @Date: 2021/4/30
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OrderServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderServer01Application.class, args);
    }

}