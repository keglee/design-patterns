package com.iversonx.prototype.order;

public class EnterpriseOrder implements OrderPrototype{
    private String enterpriseName;
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
        EnterpriseOrder order = new EnterpriseOrder();
        order.setEnterpriseName(enterpriseName);
        order.setOrderProductNum(orderProductNum);
        order.setProductId(productId);
        return order;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String toString() {
        return "订单类型[企业订], 订购公司是[" + enterpriseName + "], 订购产品是[" + productId + "], 订购数量为[" + orderProductNum + "]";
    }
}
