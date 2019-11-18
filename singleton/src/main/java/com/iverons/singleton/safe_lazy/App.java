package com.iverons.singleton.safe_lazy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式单例，通过synchronized修饰，不会出现多个实例
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
