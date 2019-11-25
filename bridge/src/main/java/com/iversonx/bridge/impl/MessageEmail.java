package com.iversonx.bridge.impl;

import com.iversonx.bridge.impl.MessageImplementor;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/25 19:42
 */
public class MessageEmail implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用邮件的方式，发送消息[" + message + "]给" + toUser);
    }
}
