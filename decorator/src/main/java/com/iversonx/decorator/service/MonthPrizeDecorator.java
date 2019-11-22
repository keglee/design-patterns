package com.iversonx.decorator.service;

import com.iversonx.decorator.TempDB;

// 计算当月业务奖金
public class MonthPrizeDecorator extends Decorator {

    public MonthPrizeDecorator(Component c) {
        super(c);
    }

    public double calcPrize(String user) {
        double money = super.calcPrize(user);
        double sale = TempDB.MONTH_SALE_MONTY.get(user);
        double prize = sale * 0.03;
        System.out.println(user + "当月销售额为 " + sale + ", 当月业务奖金:" + prize);
        return money + prize;
    }
}