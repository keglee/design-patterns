package com.iversonx.bridge;

import com.iversonx.bridge.abst.AbstractMessage;
import com.iversonx.bridge.abst.CommonMessage;
import com.iversonx.bridge.abst.SpecialUrgencyMessage;
import com.iversonx.bridge.abst.UrgencyMessage;
import com.iversonx.bridge.impl.MessageImplementor;
import com.iversonx.bridge.impl.MessageSMS;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/25 19:38
 */
public class Application {
    public static void main(String[] args) {
        MessageImplementor impl = new MessageSMS();
        AbstractMessage m = new CommonMessage(impl);
        m.sendMessage("这是个普通消息", "张三");

        m = new UrgencyMessage(impl);
        m.sendMessage("十万火急，请快处理", "李四");

        m = new SpecialUrgencyMessage(impl);
        m.sendMessage("特急：快快处理", "赵柳");
    }
}
