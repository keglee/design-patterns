package com.iversonx.prototype.order;

public class PersonalOrder implements OrderPrototype{
    private String customerName;
    private String productId;
    private int orderProductNum;


    @Override
    public int getOrderProductNum() {
        return orderProductNum;
    }

    @Override
    public void setOrderProductNum(int number) {
        this.orderProductNum = number;
    }

    @Override
    public OrderPrototype cloneOrder() {
        PersonalOrder order = new PersonalOrder();
        order.setCustomerName(customerName);
        order.setProductId(productId);
        order.setOrderProductNum(orderProductNum);
        return order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String toString() {
        return "订单类型[个人订单], 订购人是[" + customerName + "], 订购产品是[" + productId + "], 订购数量为[" + orderProductNum + "]";
    }
}
