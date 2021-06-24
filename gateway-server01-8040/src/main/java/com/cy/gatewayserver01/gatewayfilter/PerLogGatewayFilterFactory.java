package com.cy.gatewayserver01.gatewayfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * @Author: 烟幕
 * @Date: 2021/5/4
 * @Description:
 */
@Slf4j
@Component
public class PerLogGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {

        return ((exchange, chain) -> {
            log.info("请求进来了[2]....., config1={},config2={}",config.getName(),config.getValue());
            ServerHttpRequest modifiedRequest = exchange.getRequest()
                    .mutate()
                    .build();

            ServerWebExchange modifiedExchange = exchange.mutate()
                    .request(modifiedRequest)
                    .build();

            return chain.filter(modifiedExchange);
        });
    }
}
