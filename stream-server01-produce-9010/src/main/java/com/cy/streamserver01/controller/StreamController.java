package com.cy.streamserver01.controller;

import com.cy.streamserver01.producer.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 烟幕
 * @Date: 2021/5/6
 * @Description:
 */
@RestController
@RequestMapping("stream")
public class StreamController {

    @Resource
    private Source source1;

    @Resource
    private MySource mySource1;

    @GetMapping("stream01/{msg}")
    public String stream01(@PathVariable("msg") String msg) {

        // 向mq发送消息
        boolean msg1 = source1.output().send (
                MessageBuilder
                        .withPayload("stream消息体: " + msg)
                        .build()
        );

        return String.valueOf(msg1);
    }

    @GetMapping("stream02/{msg}")
    public String stream02(@PathVariable("msg") String msg) {

        // 向mq发送消息
        boolean msg1 = mySource1.output().send (
                MessageBuilder
                        .withPayload("自定义消息体: " + msg)
                        .build()
        );

        return String.valueOf(msg1);
    }

    /**
     * 延迟消费demo
     * @param msg
     * @return
     */
    @GetMapping("delay/{msg}")
    public String delay(@PathVariable("msg") String msg) {

        String key = "delay";

        // 向mq发送消息
        boolean msg1 = mySource1.delayOutput().send(
                MessageBuilder
                        .withPayload("延迟消息: " + msg)
                        .setHeader(MessageConst.PROPERTY_KEYS, key)
                        .setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, "3") // 设置延迟级别为3, 10 秒后消费。
                        .setHeader(MessageConst.PROPERTY_TAGS, msg)
                        .build()
        );

        return String.valueOf(msg1);
    }

}
