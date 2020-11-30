package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-11-27 16:25
 * @Version 1.0
 **/
public class TestObjWait {

    public static void main(String[] args) throws InterruptedException {
        test1();
//        test2();
    }

    public static void test1() throws InterruptedException {
        final Object obj = new Object();
        Thread t1 = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("sum=" + sum);
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("finish");
        }, "t1");
        t1.start();

        // 如果不sleep，可能会一直阻塞，与wait和notify的顺序有关
        Thread.sleep(200);
        synchronized (obj) {
            obj.notify();
        }
    }

    public static void test2() throws InterruptedException {
        final Object obj = new Object();
        Thread t2 = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("sum=" + sum);
            LockSupport.park();
            System.out.println("finish");
        }, "t2");
        t2.start();

        Thread.sleep(200);
        LockSupport.unpark(t2);
    }
}
