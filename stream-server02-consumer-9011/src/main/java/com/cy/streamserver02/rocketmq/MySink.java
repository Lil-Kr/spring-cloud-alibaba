package com.cy.streamserver02.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author: 烟幕
 * @Date: 2021/5/7
 * @Description:
 */
public interface MySink {

    /** ============= 普通消费 ================**/
    String MY_INPUT = "my-input";

    @Input(MY_INPUT)
    SubscribableChannel input();

    /** ============= 延迟消费 ================**/
    String DELAY_INPUT = "delay-input";

    @Input(DELAY_INPUT)
    MessageChannel delayInput();
}