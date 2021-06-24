package com.cy.userconsumer.project.controller;

import com.cy.userprovider.project.service.UserService;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 烟幕
 * @Date: 2021/4/22
 * @Description:
 */
@RestController
@RequestMapping("testcontroller")
public class TestController {

    @DubboReference
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getUserInfo")
    public String getUserInfo (@RequestParam("userinfo") String userinfo) {
        String userInfo = userService.getUserInfo(userinfo);
        return userInfo + " prot: " + port;
    }

    @GetMapping("spitest")
    public String spitest() {
        LoadBalance loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("mineLoadBalance");
        Protocol adaptiveExtension = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        System.out.println(adaptiveExtension.getClass());
        return "";
    }


    @GetMapping("testSPI")
    public void testSPI() {
        
    }
}