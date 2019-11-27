package com.iversonx.flyweight;

import com.iversonx.flyweight.impl.AuthorizationFlyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();
    private FlyweightFactory() {}

    public static FlyweightFactory getFactory(){
        return factory;
    }

    /**
     * 缓存多个享元对象
     */
    private Map<String, Flyweight> cache = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight f = cache.get(key);
        if(f == null) {
            f= new AuthorizationFlyweight(key);
            cache.put(key, f);
        }
        return f;
    }
}
