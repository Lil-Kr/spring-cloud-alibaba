package com.cy.orderserver01.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 烟幕
 * @Date: 2021/5/1
 * @Description:
 */
@Component
//@FeignClient(name = "user-server01",path = "user", configuration = GlobalFeignConfiguration.class)
@FeignClient(name = "user-server01-8085",path = "user")
public interface UserFeignClient {

    /**
     * http://user-server01/user/test1/{name}
     * @param: name
     * @return:
     */
    @GetMapping("/test1/{name}")
    String test1(@PathVariable("name") String name);
}