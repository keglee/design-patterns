package com.iverson.proxy;

public class Proxy implements Subject {
    private Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    public void request() {
        System.out.println("通过代理对象来访问真实对象");
        subject.request();
    }
}
