package com.iversonx.bridge.impl;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/25 19:42
 */
public class MessageMobile implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用手机短信的方式，发送消息[" + message + "]给" + toUser);
    }
}
