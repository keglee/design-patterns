package com.iversonx.strategy.quote;

public class OldCustomerQuote implements Quote {
    public double quotePrice(double goodsPrice) {
        goodsPrice = goodsPrice * (1 - 0.05);
        System.out.println("对于老客户, 统一折扣5%, 折后价格为" + goodsPrice);
        return goodsPrice;
    }
}
