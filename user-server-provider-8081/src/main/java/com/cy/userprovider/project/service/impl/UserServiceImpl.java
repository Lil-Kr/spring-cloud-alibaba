package com.cy.userprovider.project.service.impl;

import com.cy.userprovider.project.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Author: 烟幕
 * @Date: 2021/4/22
 * @Description:
 */
@DubboService // 发布接口服务
public class UserServiceImpl implements UserService {

    @Override
    public String getUserInfo(String name) {
        return "dubbo: " + name;
    }
}
