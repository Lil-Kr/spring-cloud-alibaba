package com.cy.userserver01.sentinelconfig;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.UrlCleaner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: 烟幕
 * @Date: 2021/5/4
 * @Description:
 */
@Component
@Slf4j
public class MyUrlCleaner implements UrlCleaner {

    @Override
    public String clean(String s) {
        log.warn("originUrl = {}",s);
        // /user/test{number}

        String[] urls = s.split("/");

//        return Arrays.stream(urls)
//                .map(str -> {
//                    if (str.startsWith("test")) {
//
//                    }
//                })
//                .reduce(())
//                .orElse("");
        return s;
    }
}

