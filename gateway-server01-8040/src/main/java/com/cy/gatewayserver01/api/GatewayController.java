package com.cy.gatewayserver01.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 烟幕
 * @Date: 2021/5/28
 * @Description:
 */
@RestController
@RequestMapping("gateway")
public class GatewayController {

    @GetMapping("test01")
    public String test01 () {
        return "test01";
    }

}