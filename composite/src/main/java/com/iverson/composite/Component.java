package com.iverson.composite;

/**
 * 抽象组件
 */
public abstract class Component {
    public abstract void printStruct(String preStr);

    public void addChild(Component child) {
        throw new UnsupportedOperationException("不支持这个功能");
    }

    public void removeChild(Component child) {
        throw new UnsupportedOperationException("不支持这个功能");
    }

    public Component getChildren(int index) {
        throw new UnsupportedOperationException("不支持这个功能");
    }
}
