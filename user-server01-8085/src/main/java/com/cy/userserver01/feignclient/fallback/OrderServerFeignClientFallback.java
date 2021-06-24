package com.cy.userserver01.feignclient.fallback;

import com.cy.userserver01.feignclient.OrderService;
import com.google.common.collect.Lists;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 烟幕
 * @Date: 2021/5/3
 * @Description:
 */
@Component
public class OrderServerFeignClientFallback implements OrderService {

    @Override
    public List<ServiceInstance> test1() {
        return Lists.newArrayList();
    }

    @Override
    public String test4() {
        return "使用Feign发生限流或者熔断";
    }
}