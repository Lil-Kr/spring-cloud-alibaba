package com.cy.orderserver01.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Author: 烟幕
 * @Date: 2021/5/1
 * @Description: Feign全局配置
 */
public class GlobalFeignConfiguration {

    @Bean
    public Logger.Level level () {
        return Logger.Level.FULL;
    }

}
