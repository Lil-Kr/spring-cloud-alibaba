package com.cy.gatewayserver01.gatewaypredicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: 烟幕
 * @Date: 2021/5/4
 * @Description:
 */
@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenConfig> {


    public TimeBetweenRoutePredicateFactory() {
        super(TimeBetweenConfig.class);
    }

    /**
     * 控制路由的条件
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(TimeBetweenConfig config) {

        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();
        return exchange -> {
            exchange.getRequest().getQueryParams();
            LocalTime now = LocalTime.now();
            return now.isAfter(start) && now.isBefore(end);
        };
    }

    /**
     * 控制配置类和配置文件映射的顺序关系
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("start","end");
    }
}