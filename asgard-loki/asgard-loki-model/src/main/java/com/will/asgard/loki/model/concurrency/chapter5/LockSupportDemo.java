package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description rt
 * @Auther maolingwei
 * @Date 2020-11-03 11:15
 * @Version 1.0
 **/
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }
}
