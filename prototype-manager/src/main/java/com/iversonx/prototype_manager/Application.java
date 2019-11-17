package com.iversonx.prototype_manager;

public class Application {
    public static void main(String[] args) throws Exception{
        Prototype p = new ConcretePrototype1();
        p.setName("Prototype1");
        PrototypeManager.setPrototype(p.getName(), p);

        // 获取原型来场景对象
        Prototype p2 = PrototypeManager.getPrototype(p.getName()).clone();
        System.out.println("第一个实例:" + p2);

        // 切换原型
        PrototypeManager.setPrototype(p.getName(), new ConcretePrototype2());

        // 再次获取
        Prototype p3 = PrototypeManager.getPrototype(p.getName()).clone();
        System.out.println("第二个实例:" + p3);

        // 注销
        PrototypeManager.removePrototype(p.getName());

        // 再次尝试获取
        Prototype p4 = PrototypeManager.getPrototype(p.getName()).clone();
        System.out.println("第三个实例:" + p4);

    }
}
