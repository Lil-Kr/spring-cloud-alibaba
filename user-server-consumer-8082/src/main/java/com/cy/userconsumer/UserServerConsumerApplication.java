package com.cy.userconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 烟幕
 * @Date: 2021/4/22
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServerConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServerConsumerApplication.class, args);
    }
}
