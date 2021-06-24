package com.cy.streamserver01.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Author: 烟幕
 * @Date: 2021/5/7
 * @Description:
 */
//@RocketMQTransactionListener
public interface MySource {

    /** ============= 普通消费 ================**/
    String MY_OUTPUT = "my-output";

    @Output(MY_OUTPUT)
    MessageChannel output();

    /** ============= 延迟消费 ================**/
    String DELAY_OUTPUT = "delay-output";

    @Output(DELAY_OUTPUT)
    MessageChannel delayOutput();

}