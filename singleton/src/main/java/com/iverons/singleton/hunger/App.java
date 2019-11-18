package com.iverons.singleton.hunger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 19:54
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
