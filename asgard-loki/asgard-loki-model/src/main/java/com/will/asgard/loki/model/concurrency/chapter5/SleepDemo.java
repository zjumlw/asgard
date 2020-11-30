package com.will.asgard.loki.model.concurrency.chapter5;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-27 下午11:17
 * @Version 1.0
 */
public class SleepDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(threadName + " is interrupted, break");
                    break;
                }
                try {
                    System.out.println(threadName + " is going to sleep for 1s");
                    Thread.sleep(1000);
                    System.out.println(threadName + " woke up");
                } catch (InterruptedException e) {
                    System.out.println(threadName + " is interrupted, catch exception");
                    System.out.println(threadName + " interrupt itself");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(threadName + " after while");
        });

        t1.start();
        Thread.sleep(100);

        System.out.println("Main thread try to interrupt t1 thread");
        t1.interrupt();
        System.out.println("Main thread after interrupt t1 thread");
    }
}
