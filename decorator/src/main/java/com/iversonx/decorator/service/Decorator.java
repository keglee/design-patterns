package com.iversonx.decorator.service;

// 装饰器
public abstract class Decorator extends Component {
    protected Component c;

    public Decorator(Component c) {
        this.c = c;
    }

    public double calcPrize(String user) {
        return c.calcPrize(user);
    }
}
