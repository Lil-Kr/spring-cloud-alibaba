package com.cy.sentinel.project;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author: 烟幕
 * @Date: 2021/4/25
 * @Description: 令牌桶算法
 */
public class RateLimiterDemo {

    RateLimiter rateLimiter = RateLimiter.create(10);

    public void doRequest() {
        if (rateLimiter.tryAcquire()) {
            System.out.println("成功");
        }else {
            
        }
    }

    public static void main(String[] args) {

    }

}