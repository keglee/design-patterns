package com.iverons.singleton.hunger;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 19:51
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
