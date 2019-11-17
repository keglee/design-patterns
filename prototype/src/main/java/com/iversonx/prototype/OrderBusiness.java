package com.iversonx.prototype;

import com.iversonx.prototype.order.OrderPrototype;

import java.util.ArrayList;
import java.util.List;

public class OrderBusiness {
    private final static int MAX_NUM = 1000;
    public void saveOrder(OrderPrototype order) {
        List<OrderPrototype> list = new ArrayList<>();
        // 判断当前订单的产品数量是否大于1000
        while (order.getOrderProductNum() > MAX_NUM) {
            // 如果大于1000，就进行拆分
            // 克隆一份订单
            OrderPrototype newOrder = order.cloneOrder();
            // 设置产品数量为1000
            newOrder.setOrderProductNum(MAX_NUM);
            // 原订单的产品数量减去1000
            order.setOrderProductNum(order.getOrderProductNum() - MAX_NUM);
            list.add(newOrder);
        }
        list.add(order);

        System.out.println("订单拆分后，共有" + list.size() + "份订单");
        for(OrderPrototype o : list) {
            System.out.println(o);
        }
    }
}
