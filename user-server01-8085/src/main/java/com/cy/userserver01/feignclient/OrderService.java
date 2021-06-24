package com.cy.userserver01.feignclient;

import com.cy.userserver01.feignclient.fallback.OrderServerFeignClientFallbackFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: 烟幕
 * @Date: 2021/5/3
 * @Description:
 */
@Component
@FeignClient(name = "order-server01"
        ,path = "order"
        ,fallbackFactory = OrderServerFeignClientFallbackFactory.class
        /*,fallback = OrderServerFeignClientFallback.class*/
        /*,configuration = FeignConfiguration.class*/)
public interface OrderService {

    @GetMapping("/test1")
    List<ServiceInstance> test1();

    @GetMapping("/test4")
    String test4();
}
