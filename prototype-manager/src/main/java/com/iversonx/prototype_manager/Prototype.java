package com.iversonx.prototype_manager;

public interface Prototype {
    Prototype clone() throws CloneNotSupportedException;
    String getName();
    void setName(String name);
}
