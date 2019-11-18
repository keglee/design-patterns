package com.iverons.singleton.double_check;

import java.io.Serializable;
import java.util.Random;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 19:52
 */
public class Singleton implements Serializable {
    private static volatile Singleton instance;
    private static boolean flag = false;
    private Singleton() {
        if(flag) {
            throw new InstantiationError("error");
        } else {
            flag = true;
        }
    }

    public static Singleton getInstance() {
        Random r = new Random();

        if(instance == null) {
            try {
                Thread.sleep((long)r.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
