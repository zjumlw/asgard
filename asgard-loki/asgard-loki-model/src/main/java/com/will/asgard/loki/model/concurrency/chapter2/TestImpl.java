package com.will.asgard.loki.model.concurrency.chapter2;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-02 12:52 上午
 * @Version 1.0
 */
class TestImpl implements Test{
//    @Override
//    public synchronized void doSomeThing() {
//
//    }

    synchronized void sayHello(Test test, Apple apple) {
        System.out.println("hello");
        String name = Thread.currentThread().getName();
        boolean b = Thread.holdsLock(test);
        System.out.println(name + " holds lock of test: " + b);
        boolean b1 = Thread.holdsLock(apple);
        System.out.println(name + " holds lock of apple: " + b1);
    }

    public static void main(String[] args) throws InterruptedException {
        TestImpl test = new TestImpl();
        Apple apple = new Apple();
        new Thread(() -> test.doSomeThing(test, apple)).start();
        Thread.sleep(20);
        test.sayHello(test, apple);
    }
}
