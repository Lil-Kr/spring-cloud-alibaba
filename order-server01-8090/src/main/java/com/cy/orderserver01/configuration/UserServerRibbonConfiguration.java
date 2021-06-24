package com.cy.orderserver01.configuration;

import com.cy.configuration.ribbonconfiguration.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 烟幕
 * @Date: 2021/5/1
 * @Description: 指定为 user-server01 的Ribbon配置
 */
//@RibbonClient(name="user-server01", configuration = RibbonConfiguration.class)
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@Configuration
public class UserServerRibbonConfiguration {

}