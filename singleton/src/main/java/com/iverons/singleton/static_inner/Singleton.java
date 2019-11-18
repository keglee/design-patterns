package com.iverons.singleton.static_inner;

import java.io.Serializable;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 19:52
 */
public class Singleton implements Serializable {
    private Singleton() {
        if(SingletonHolder.instance != null) {
            throw new InstantiationError("error");
        }
    }
    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private Object readResolve() {
        return SingletonHolder.instance;
    }
}
