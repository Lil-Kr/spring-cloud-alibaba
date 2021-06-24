package com.cy.rocketmqserver01.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 烟幕
 * @Date: 2021/5/5
 * @Description:
 */
@RestController
@RequestMapping("rocket")
public class RocketMQController {

    @Resource
    private RocketMQTemplate rocketMQTemplate1;

    @GetMapping("test1")
    public String test1() {

        // 发送消息
        Map<String, Object> msg = new HashMap<>();
        msg.put("666","cy");
        rocketMQTemplate1.convertAndSend("topic-01", msg);
        return JSONObject.toJSONString(msg);
    }

}