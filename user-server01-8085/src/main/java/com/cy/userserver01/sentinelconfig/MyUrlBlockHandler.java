package com.cy.userserver01.sentinelconfig;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 烟幕
 * @Date: 2021/5/4
 * @Description:
 */
@Component
public class MyUrlBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        ErrorMsg msg = null;
        if (e instanceof FlowException) {// 限流异常
            msg = ErrorMsg.builder()
                    .status(100)
                    .msg("限流异常")
                    .build();
        }else if (e instanceof AuthorityException) {// 授权规则异常
            msg = ErrorMsg.builder()
                    .status(101)
                    .msg("授权规则异常")
                    .build();
        }else if (e instanceof DegradeException) {// 降级异常
            msg = ErrorMsg.builder()
                    .status(102)
                    .msg("降级异常")
                    .build();
        }else if (e instanceof ParamFlowException) {// 参数流动异常
            msg = ErrorMsg.builder()
                    .status(103)
                    .msg("参数流动异常")
                    .build();
        }else if (e instanceof SystemBlockException) {// 系统异常
            msg = ErrorMsg.builder()
                    .status(104)
                    .msg("系统异常")
                    .build();
        }

        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        new ObjectMapper()
                .writeValue(response.getWriter(),msg);

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ErrorMsg {
    private Integer status;
    private String msg;
}