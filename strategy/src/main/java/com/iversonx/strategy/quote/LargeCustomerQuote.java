package com.iversonx.strategy.quote;

public class LargeCustomerQuote implements Quote {
    public double quotePrice(double goodsPrice) {
        goodsPrice = goodsPrice * (1 - 0.1);
        System.out.println("对于大客户, 统一折扣10%, 折后价格为" + goodsPrice);
        return goodsPrice;
    }
}
