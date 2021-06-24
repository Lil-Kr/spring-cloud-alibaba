package com.cy.userserver01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 烟幕
 * @Date: 2021/4/30
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients
public class UserServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(UserServer01Application.class, args);
    }

}
