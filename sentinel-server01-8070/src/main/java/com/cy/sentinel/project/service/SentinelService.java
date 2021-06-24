package com.cy.sentinel.project.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @Author: 烟幕
 * @Date: 2021/4/25
 * @Description:
 */
@Service
public class SentinelService {

    @SentinelResource(
            value = "doTest"// 声明限流的资源
            , blockHandler="blockHandler"// 配置被限流之后的提示逻辑
            , fallback = "fallback"
    )
    public String doTest(String name) {
        return "hello, " + name;
    }

    /**
     * 传递被限流时候的异常
     * @param name
     * @param e
     * @return
     */
    public String blockHandler(String name, BlockException e) {
        return name + " 被限流之后发生的降级";
    }

    /**
     * 传递被熔断时候触发的
     * @param name
     * @return
     */
    public String fallback (String name) {
        return name + " 被熔断之后发生的降级";
    }

}
