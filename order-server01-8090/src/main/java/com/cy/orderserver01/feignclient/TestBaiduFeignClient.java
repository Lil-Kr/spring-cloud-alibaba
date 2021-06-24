package com.cy.orderserver01.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 烟幕
 * @Date: 2021/5/1
 * @Description:
 */
@Component
@FeignClient(name = "xxx", url = "https://www.baidu.com")
public interface TestBaiduFeignClient {

    @GetMapping("")
    String baidu();
}
