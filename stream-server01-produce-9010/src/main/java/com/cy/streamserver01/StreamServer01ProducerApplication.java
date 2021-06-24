package com.cy.streamserver01;

import com.cy.streamserver01.producer.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @Author: 烟幕
 * @Date: 2021/5/6
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding({Source.class, MySource.class})
public class StreamServer01ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamServer01ProducerApplication.class, args);
    }

}
