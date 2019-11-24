package com.iverson.proxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("具体目标对象");
    }
}
