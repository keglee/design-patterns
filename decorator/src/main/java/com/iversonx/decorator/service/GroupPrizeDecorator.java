package com.iversonx.decorator.service;

import com.iversonx.decorator.TempDB;

public class GroupPrizeDecorator extends Decorator {
    // 计算当月团队业务奖金
    public GroupPrizeDecorator(Component c) {
        super(c);
    }

    public double calcPrize(String user) {
        double money = super.calcPrize(user);
        // 计算当月团队业务奖金，先计算出团队总的业务额，然后再乘以1%
        // 假设都是一个团队的
        double group = 0.0;
        for(double d : TempDB.MONTH_SALE_MONTY.values()) {
            group += d;
        }
        double prize = group * 0.01;
        System.out.println(user + " 当月团队业务奖金:" + prize);
        return money + prize;
    }
}
