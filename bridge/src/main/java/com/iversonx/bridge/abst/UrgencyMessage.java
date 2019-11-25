package com.iversonx.bridge.abst;

import com.iversonx.bridge.impl.MessageImplementor;

// 加急消息
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    public void sendMessage(String message, String toUser) {
        message = "加急: " + message;
        super.sendMessage(message, toUser);
    }

    // 扩展自己的功能，监控消息的处理
    public void watch(String messageId) {
        System.out.println("监控消息的处理");
    }
}
