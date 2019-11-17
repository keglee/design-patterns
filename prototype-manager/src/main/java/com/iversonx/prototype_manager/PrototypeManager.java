package com.iversonx.prototype_manager;

import java.util.HashMap;
import java.util.Map;

public class PrototypeManager {
    /**
     * 用来记录原型编号和原型实例的对应关系
     */
    private static Map<String, Prototype> map = new HashMap<>();

    /**
     * 私有构造方法，避免外部无谓的创建实例
     */
    private PrototypeManager() {

    }

    /**
     * 添加或修改原型
     * @param id 原型编号
     * @param prototype 原型实例
     */
    public synchronized static void setPrototype(String id, Prototype prototype) {
        map.put(id, prototype);
    }

    /**
     * 删除原型
     * @param id 原型编号
     */
    public synchronized static void removePrototype(String id) {
        map.remove(id);
    }

    public synchronized static Prototype getPrototype(String id) {
        if(map.containsKey(id)) {
            throw new RuntimeException("原型不存在或已被删除");
        }
        return map.get(id);
    }
}
