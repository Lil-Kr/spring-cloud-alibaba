package com.cy.userserver01.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSONArray;
import com.cy.userserver01.feignclient.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 烟幕
 * @Date: 2021/4/30
 * @Description:
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Value("${spring.application.name}")
    private String appName;

    @Resource
    private DiscoveryClient discoveryClient1;

    @GetMapping("/test1/{name}")
    public String test1 (@PathVariable("name") String name) {
        String info = "user-server 被调用了, 参数: " + name;
        System.out.println(info);
        List<ServiceInstance> instances = discoveryClient1.getInstances(appName);
        return JSONArray.toJSONString(instances);
    }

    @SentinelResource("hot")
    @GetMapping("/test-hot")
    public String testHot(@RequestParam(required = false) String a,
                          @RequestParam(required = false) String b) {
        return a + b;
    }

    @GetMapping("/test-add-flow-rule")
    public String testAddFlowRule() {
        this.initFlowQpsRule();
        return "testAddFlowRule";
    }

    private void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("");
        // set limit qps to 20
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    @GetMapping("/test-sentinel-api")
    @SentinelResource(value = "test-sentinel-api", blockHandler = "block",fallback = "fallback")
    public String testSentinelApi(@RequestParam(required = false) String a) {
        // 定义一个sentinel保护的资源, 名称是 test-sentinel-api
//        Entry entry = null;
//        String resName = "test-sentinel-api";
//        ContextUtil.enter(resName,"test-wfw");
        if (StringUtils.isEmpty(a)) {
            throw new IllegalArgumentException("a不能为空");
        }
        return a;

//        try {
//            entry = SphU.entry(resName);
//            return a;
//        } catch (BlockException e) {
////            e.printStackTrace();
////            log.info("被限流或者降级了");
////            return "被限流或者降级了";
//        }catch (IllegalArgumentException e2){
//            // 统计 IllegalArgumentException
//            Tracer.trace(e2);
//            return "参数非法";
//        } finally {
//            if (entry != null) {
//                entry.exit();
//            }
//        }
    }

    /**
     * 处理限流或者降级
     * @param a
     * @param e
     * @return
     */
    public String block(String a, BlockException e) {
        log.warn("block方法, 限流, 或者降级, 参数a={}",a);
        return "block方法, 限流, 或者降级, 参数a=" + a;
    }

    /**
     * 处理降级
     * @param a
     * @return
     */
    public String fallback(String a) {
        return "fallback: " + a;
    }

    @Resource
    private RestTemplate restTemplate1;

    /**
     * RestTemplate 整合 Sentinel
     * @return
     */
    @GetMapping("/test-rest-template/{value}")
    @SentinelResource(value = "test-rest-template", blockHandler = "block",fallback = "fallback")
    public List<ServiceInstance> testRestTemplate(@PathVariable("value") String value) {
        return restTemplate1.getForObject("http://order-server01/order/test1", List.class);
    }

    @Resource
    private OrderService orderService1;

    @SentinelResource(value = "test-feign-sentinel")
    @GetMapping("/test-feign-sentinel")
    public String testFeignSentinel() {
        String s = orderService1.test4();
        return s;
    }

    @SentinelResource(value = "test3")
    @GetMapping("/test3")
    public String test3() {
        String s = orderService1.test4();
        return s;
    }

    @SentinelResource(value = "test4")
    @GetMapping("/test4")
    public String test4() {
        String s = orderService1.test4();
        return s;
    }

}