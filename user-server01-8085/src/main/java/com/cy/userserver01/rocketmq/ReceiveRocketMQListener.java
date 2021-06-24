package com.cy.userserver01.rocketmq;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: 烟幕
 * @Date: 2021/5/6
 * @Description:
 * RocketMQListener<消息体>
 */
@Service
@RocketMQMessageListener(consumerGroup = "test-consumer-group", topic = "topic-01")
@Slf4j
public class ReceiveRocketMQListener implements RocketMQListener<HashMap> {

    /**
     * 收到消息时具体的业务实现
     * @param message
     */
    @Override
    public void onMessage(HashMap message) {
        log.warn("测试消费者消费消息, msg={}", JSONObject.toJSONString(message));
    }
}