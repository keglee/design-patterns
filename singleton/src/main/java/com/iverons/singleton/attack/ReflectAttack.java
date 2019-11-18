package com.iverons.singleton.attack;


import com.iverons.singleton.static_inner.Singleton;

import java.lang.reflect.Constructor;

/**
 * 使用反射破坏单例
 * @author Lijie
 * @version 1.0
 * @date 2019/11/18 20:23
 */
public class ReflectAttack {
    public static void main(String[] args) throws Exception {

        Class objClass = Singleton.class;
        // 获取类的构造器
        Constructor constructor = objClass.getDeclaredConstructor();
        // 把构造器私有权限放开
        constructor.setAccessible(true);
        // 反射创建实例
        Singleton newSingleton = (Singleton) constructor.newInstance();
        System.out.println(newSingleton);

        // 正常的获取实例方式
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);






    }
}
