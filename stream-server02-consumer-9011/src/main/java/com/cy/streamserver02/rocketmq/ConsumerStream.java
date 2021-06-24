package com.cy.streamserver02.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @Author: 烟幕
 * @Date: 2021/5/6
 * @Description:
 */
@Service
@Slf4j
public class ConsumerStream {

    @StreamListener(Sink.INPUT)
    public void receiver(String msg) {
        log.info("收到来自Stream的消息: {}", msg);
    }

    @StreamListener(MySink.MY_INPUT)
    public void receiver02(String msg) {
        log.info("自定义Stream的消息: {}", msg);
    }

    @StreamListener(MySink.DELAY_INPUT)
    public void delay01(String msg) {
        log.info("延迟消费: {}", msg);
    }

}