package com.iversonx.bridge.abst;

import com.iversonx.bridge.impl.MessageImplementor;

// 普通消息
public class CommonMessage extends AbstractMessage {
    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }

    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
