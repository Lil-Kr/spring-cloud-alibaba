package com.cy.orderserver01.controller;

import com.alibaba.fastjson.JSONArray;
import com.cy.orderserver01.feignclient.TestBaiduFeignClient;
import com.cy.orderserver01.feignclient.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @Author: 烟幕
 * @Date: 2021/4/30
 * @Description:
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Value("${spring.application.name}")
    private String appName;

    @Resource
    private DiscoveryClient discoveryClient1;

    @Resource
    private RestTemplate restTemplate1;

    @GetMapping("/test1")
    public String test1 () {
        List<ServiceInstance> instances = discoveryClient1.getInstances(appName);
        log.info("instances: {}", JSONArray.toJSONString(instances));
        return JSONArray.toJSONString(instances);
    }

    @GetMapping("/test2")
    public String test2 () {
        List<ServiceInstance> instances = discoveryClient1.getInstances(appName);
        List<String> targetUrls = instances.stream()
                .map(instance -> instance.getUri().toString() + "/user/test1/{name}")
                .collect(Collectors.toList());

        log.info("具体请求地址:{}",JSONArray.toJSONString(instances));

        // 随机选一个地址调用
        int index = ThreadLocalRandom.current().nextInt(targetUrls.size());

        log.info("具体请求地址:{}",targetUrls.get(index));

        String forObject = restTemplate1.getForObject(
                "http://user-server01/user/test1/{name}",
                String.class,
                "调用user-server01服务");
        System.out.println(forObject);
        return "sss";
    }


    @GetMapping("/test3")
    public String test3 () {
        log.info("test3");
        return "test3";
    }

    @Resource
    private UserFeignClient userFeignClient1;

    @Resource
    private TestBaiduFeignClient testBaiduFeignClient1;

    @GetMapping("/test3feign/{name}")
    public String test3feign(@PathVariable("name") String name) {
        String s = userFeignClient1.test1(name);
        return s;
    }

    @GetMapping("/baidu")
    public String baidu() {
        return testBaiduFeignClient1.baidu();
    }

    @GetMapping("/test4")
    public String test4() {
        return "test4";
    }

}