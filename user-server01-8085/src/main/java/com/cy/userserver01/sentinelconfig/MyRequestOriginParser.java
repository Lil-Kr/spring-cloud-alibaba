package com.cy.userserver01.sentinelconfig;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 烟幕
 * @Date: 2021/5/4
 * @Description:
 */
//@Component
public class MyRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        // 从请求参数中获取 origin的参数

        String origin = request.getParameter("origin");
        if (StringUtils.isBlank(origin)) {
            throw new IllegalArgumentException("origin是必须的");
        }
        return origin;
    }
}