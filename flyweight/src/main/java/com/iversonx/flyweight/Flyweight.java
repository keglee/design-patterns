package com.iversonx.flyweight;

public interface Flyweight {
    /**
     * 判断传入的安全实体和权限，是否和享元对象内部状态匹配
     * @param entity 安全实体
     * @param permit 权限
     * @return true， false
     */
    boolean match(SecurityEntity entity, Permit permit);
}
