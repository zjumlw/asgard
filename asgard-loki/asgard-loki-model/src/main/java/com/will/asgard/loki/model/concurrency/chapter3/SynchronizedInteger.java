package com.will.asgard.loki.model.concurrency.chapter3;

import javax.annotation.concurrent.GuardedBy;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-02 10:29 下午
 * @Version 1.0
 */
class SynchronizedInteger {
    @GuardedBy("this") private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedInteger synchronizedInteger = new SynchronizedInteger();
        Thread thread1 = new Thread(() -> {
            System.out.println("ok");
            synchronizedInteger.setValue(10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread1.join();

        System.out.println(synchronizedInteger.getValue());
    }
}
