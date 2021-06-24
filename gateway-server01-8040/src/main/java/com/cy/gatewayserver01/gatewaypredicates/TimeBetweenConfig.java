package com.cy.gatewayserver01.gatewaypredicates;

import lombok.Data;

import java.time.LocalTime;

/**
 * @Author: 烟幕
 * @Date: 2021/5/4
 * @Description:
 */
@Data
public class TimeBetweenConfig {

    /**
     * gateway 配置的 predicates属性的第一个值
     */
    private LocalTime start;

    /**
     * gateway 配置的 predicates属性的第二个值
     */
    private LocalTime end;

}
