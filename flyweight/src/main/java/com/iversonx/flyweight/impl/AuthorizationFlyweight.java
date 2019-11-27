package com.iversonx.flyweight.impl;

import com.iversonx.flyweight.Flyweight;
import com.iversonx.flyweight.Permit;
import com.iversonx.flyweight.SecurityEntity;

/**
 * 封装授权数据中重复出现部分的享元对象
 */
public class AuthorizationFlyweight implements Flyweight {
    /**
     * 内部状态，安全实体
     */
    private SecurityEntity entity;
    /**
     * 内部状态，权限
     */
    private Permit permit;

    /**
     *
     * @param state 状态数据，包含安全实体和权限的数据
     */
    public AuthorizationFlyweight(String state) {
        String[] array = state.split(",");
        entity = new SecurityEntity(array[0]);
        permit = new Permit(array[1]);
    }

    @Override
    public boolean match(SecurityEntity entity, Permit permit) {
        return this.entity.getName().equals(entity.getName())
                && this.permit.getName().equals(permit.getName());
    }

    public SecurityEntity getEntity() {
        return entity;
    }

    public Permit getPermit() {
        return permit;
    }
}
