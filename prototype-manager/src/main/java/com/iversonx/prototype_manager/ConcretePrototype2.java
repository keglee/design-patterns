package com.iversonx.prototype_manager;

public class ConcretePrototype2 implements Prototype, Cloneable {
    private String name;
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Now in Prototype2, name=" + name;
    }
}
