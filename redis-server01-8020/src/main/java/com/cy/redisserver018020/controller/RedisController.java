package com.cy.redisserver018020.controller;

import com.cy.redisserver018020.config.redis.RedisServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 烟幕
 * @Date: 2021/5/22
 * @Description:
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisServer redisServer1;


    @GetMapping("setString/{key}/{value}")
    public String setString(@PathVariable("key") String key,@PathVariable("value") String value) {
        redisServer1.setRediskv(key,value);
        return "set String kv success";
    }

    @GetMapping("getString/{key}")
    public String getString(@PathVariable("key") String key) {
        Object rediskv = redisServer1.getRediskv(key);
        return String.valueOf(rediskv);
    }

    @GetMapping("setHash/{key}/{field}/{value}")
    public Boolean setHash(@PathVariable("key") String key,
                          @PathVariable("field") String field,
                          @PathVariable("value") String value) {

        return redisServer1.setRedisHash(key, field, value);
    }

    @GetMapping("getHash/{key}/{field}")
    public String getHash(@PathVariable("key") String key,@PathVariable("field") String field) {
        String redisHash = redisServer1.getRedisHash(key, field);
        return redisHash;
    }

}