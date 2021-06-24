package com.cy.sentinel.project;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 烟幕
 * @Date: 2021/4/25
 * @Description:
 */
public class SentinelDemo01 {

    public static void main(String[] args) {
        initFlowRules();
        while (true) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性
            try (Entry entry = SphU.entry("HelloWorld")) {
                // 被保护的逻辑
                System.out.println("hello SentinelDemo01");
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                Set set = new HashSet<String>();



                System.out.println("被拒绝!");
            }
        }
    }

    // 定义资源
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");// 设置被保护的资源对象, 这里的对象
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS); // QPS或者并发数
        // Set limit QPS to 20.
        rule.setCount(5);// 限流的线程数
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}