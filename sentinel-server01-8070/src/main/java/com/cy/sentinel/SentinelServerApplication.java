package com.cy.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 烟幕
 * @Date: 2021/4/22
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServerApplication {

    public static void main(String[] args) {
        initFlowRules();
        SpringApplication.run(SentinelServerApplication.class, args);
    }

    // 定义资源
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("doTest");// 设置被保护的资源对象
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);// Set limit QPS to 20.
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
