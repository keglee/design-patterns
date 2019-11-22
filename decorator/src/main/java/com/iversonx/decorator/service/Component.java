package com.iversonx.decorator.service;


// 定义计算奖金的组件接口
public abstract class Component {
    /**
     * 根据user来计算奖金
     */
    public abstract double calcPrize(String user);
}
