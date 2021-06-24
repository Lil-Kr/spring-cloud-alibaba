package com.cy.streamserver02;

import com.cy.streamserver02.rocketmq.MySink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @Author: 烟幕
 * @Date: 2021/5/6
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding({Sink.class, MySink.class})
public class StreamServer02ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamServer02ConsumerApplication.class, args);
    }

}
