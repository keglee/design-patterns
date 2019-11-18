package com.iverons.singleton.lazy;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 19:52
 */
public class Singleton {
    private static Singleton instance;
    private static boolean flag = false;
    private Singleton() {
        if(flag) {
            throw new InstantiationError("error");
        } else {
            flag = true;
        }
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
