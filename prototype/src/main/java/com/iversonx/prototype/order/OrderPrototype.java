package com.iversonx.prototype.order;

public interface OrderPrototype {
    int getOrderProductNum();
    void setOrderProductNum(int number);

    /**
     * 克隆方法
     * @return 原型的实例
     */
    OrderPrototype cloneOrder();
}
