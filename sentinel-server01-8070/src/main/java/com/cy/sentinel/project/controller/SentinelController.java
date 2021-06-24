package com.cy.sentinel.project.controller;

import com.cy.sentinel.project.service.SentinelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 烟幕
 * @Date: 2021/4/25
 * @Description:
 */
@RestController
@RequestMapping("sentinel")
public class SentinelController {

    @Resource
    private SentinelService sentinelService1;

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return sentinelService1.doTest(name);
    }
}