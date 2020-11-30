package com.will.asgard.loki.model.concurrency.chapter2;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-11-26 16:24
 * @Version 1.0
 **/
public class Widget {

    public synchronized void doSomething() {
        System.out.println("Widget doSomething");
        System.out.println("Widget this: " + this.toString());
    }
}
