package com.cy.nacosserver018050;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 烟幕
 * @Date: 2021/5/22
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosServer018050Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosServer018050Application.class, args);
    }

}
