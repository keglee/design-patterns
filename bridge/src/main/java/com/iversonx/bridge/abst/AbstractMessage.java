package com.iversonx.bridge.abst;

import com.iversonx.bridge.impl.MessageImplementor;

/**
 * 抽象的消息对象
 */
public abstract class AbstractMessage {
    protected MessageImplementor impl;
    public AbstractMessage(MessageImplementor impl) {
        this.impl = impl;
    }

    public void sendMessage(String message, String toUser) {
        impl.send(message, toUser);
    }
}
