package com.iverons.singleton.double_check;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式单例，双重检查加锁，变量一定要加volatile
 * <p>
 *     synchronized关键字保证的可见性是防止多个线程实例化出多个instance
 *     volatile想要解决的问题是，在另一个线程中想要使用instance，发现instance!=null，但是实际上instance还未初始化完毕
 *
 *     将instance =newInstance();步骤拆分是
 *     1.分配内存
 *     2.初始化
 *     3.将instance指向分配的内存空间。
 *     因为instance是volatile类型变量，因此在volatile写操作之前的任何操作都是不可重排序的，即23的顺序不可重排序。
 * </p>
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 19:57
 */
public class App {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Runnable runnable = () -> System.out.println(Singleton.getInstance());
        for(int i = 0; i < 5; i++) {
            service.execute(runnable);
        }
    }
}
