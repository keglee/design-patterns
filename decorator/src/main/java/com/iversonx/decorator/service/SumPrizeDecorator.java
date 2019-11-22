package com.iversonx.decorator.service;

public class SumPrizeDecorator extends Decorator {
    // 累计奖金计算
    public SumPrizeDecorator(Component c) {
        super(c);
    }

    public double calcPrize(String user) {
        double money = super.calcPrize(user);
        // 计算累计奖金，按人员去获取累计的业务额，然后再乘以0.1%
        // 这里简单演示，假设大家的累计业务额都1000000
        double prize = 1000000 * 0.001;
        System.out.println(user + " 累计奖金:" + prize);
        return money + prize;
    }
}
