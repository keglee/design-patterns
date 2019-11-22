package com.iversonx.decorator;

import com.iversonx.decorator.service.*;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/22 18:36
 */
public class Application {
    public static void main(String[] args) {
        // 首先需要创建被装饰的对象，然后创建需要的装饰对象，接着组合装饰对象，依次对前面的对象进行装饰。
        Component c = new ConcreteComponent();
        Decorator month = new MonthPrizeDecorator(c);
        Decorator sum = new SumPrizeDecorator(month);

        double zs = sum.calcPrize("张三");
        System.out.println("======== 张三应得奖金: " + zs + "========");

        double ls = sum.calcPrize("李四");
        System.out.println("======== 李四应得奖金: " + ls + "========");

        // 业务经理
        Decorator group = new GroupPrizeDecorator(sum);
        double ww = group.calcPrize("王五");
        System.out.println("======== 王五经理应得奖金: " + ww + "========");
    }
}
