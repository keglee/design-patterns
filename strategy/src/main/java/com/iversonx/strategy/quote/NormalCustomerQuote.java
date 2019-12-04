package com.iversonx.strategy.quote;

public class NormalCustomerQuote implements Quote {
    public double quotePrice(double goodsPrice) {
        System.out.println("对于新客户或者是普通客户，没有折扣，价格为" + goodsPrice);
        return goodsPrice;
    }
}
