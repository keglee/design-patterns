package com.iverons.singleton.safe_lazy;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 19:52
 */
public class Singleton {
    private static Singleton instance;
    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
