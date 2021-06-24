package com.cy.userconsumer.extensions;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;

import java.util.List;

/**
 * @Author: 烟幕
 * @Date: 2021/4/23
 * @Description: 扩展Dubbo中的负载均衡
 */
public class MineLoadBalance extends AbstractLoadBalance {

    private Protocol protocol;

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        return null;
    }
}
