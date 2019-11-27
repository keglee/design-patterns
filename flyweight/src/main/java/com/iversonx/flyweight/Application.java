package com.iversonx.flyweight;

public class Application {
    public static void main(String[] args) {
        SecurityManager manager = SecurityManager.getSecurityManager();
        manager.login("张三");
        manager.login("李四");
        SecurityEntity entity = new SecurityEntity("薪资数据");
        Permit permit = new Permit("查看");

        boolean f = manager.hasPermit("张三", entity, permit);
        boolean f2 = manager.hasPermit("李四", entity, permit);
        System.out.println("f=" + f);
        System.out.println("f2=" + f2);
        for(int i = 0; i < 3; i++) {
            manager.login("用户"+i);
            manager.hasPermit("用户" + i, entity, permit);
        }
    }
}
