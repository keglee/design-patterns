package com.iversonx.bridge.impl;

/**
 * 定义发送消息的统一接口
 */
public interface MessageImplementor {
    /**
     * 发送消息
     */
    void send(String message, String toUser);
}
