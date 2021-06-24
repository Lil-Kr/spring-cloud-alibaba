package com.cy.userserver01.feignclient.fallback;

import com.alibaba.fastjson.JSONObject;
import com.cy.userserver01.feignclient.OrderService;
import com.google.common.collect.Lists;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 烟幕
 * @Date: 2021/5/3
 * @Description:
 */
@Component
@Slf4j
public class OrderServerFeignClientFallbackFactory implements FallbackFactory<OrderService> {

    @Override
    public OrderService create(Throwable throwable) {
        return new OrderService() {
            @Override
            public List<ServiceInstance> test1() {
                return Lists.newArrayList();
            }

            @Override
            public String test4() {
                log.warn("使用Feign发生限流或者熔断, error:{}", JSONObject.toJSONString(throwable));
                return "使用Feign发生限流或者熔断";
            }
        };
    }
}