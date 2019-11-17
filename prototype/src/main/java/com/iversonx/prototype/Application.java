package com.iversonx.prototype;

import com.iversonx.prototype.order.EnterpriseOrder;
import com.iversonx.prototype.order.PersonalOrder;

public class Application {
    public static void main(String[] args) {
        EnterpriseOrder order = new EnterpriseOrder();
        order.setProductId("1548764");
        order.setOrderProductNum(2431);
        order.setEnterpriseName("腾讯计算机系统公司");

        PersonalOrder o = new PersonalOrder();
        o.setProductId("78451");
        o.setCustomerName("马化腾");
        o.setOrderProductNum(3124);

        OrderBusiness business = new OrderBusiness();
        business.saveOrder(order);
        business.saveOrder(o);


    }
}
