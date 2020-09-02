package com.will.asgard.loki.model.concurrency.chapter2;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-02 12:37 上午
 * @Version 1.0
 */
interface Test {

    default void doSomeThing(Test test, Apple apple) {
        synchronized (this) {
            try {
                System.out.println("Test do some thing");
                String name = Thread.currentThread().getName();
                boolean b = Thread.holdsLock(test);
                System.out.println(name + " holds lock of test: " + b);
                boolean b1 = Thread.holdsLock(apple);
                System.out.println(name + " holds lock of apple: " + b1);
                Thread.sleep(1000);
                System.out.println("Test ok");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
