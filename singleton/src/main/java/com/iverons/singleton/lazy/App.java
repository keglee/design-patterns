package com.iverons.singleton.lazy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 执行多次，可发现懒汉式实现单例，出现了多个实例
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
