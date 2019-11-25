package com.iversonx.bridge.abst;

import com.iversonx.bridge.impl.MessageImplementor;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/25 19:47
 */
public class SpecialUrgencyMessage extends AbstractMessage {
    public SpecialUrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    public void hurry(String messageId) {
        System.out.println("催促用户处理消息内容");
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "特急: " + message;
        super.sendMessage(message, toUser);
        hurry(message);
    }
}
