package com.will.asgard.loki.model.concurrency.chapter2;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-11-05 16:22
 * @Version 1.0
 **/
public class NoVisibility {

    private static boolean ready;
    private static int num;

    public static void main(String[] args) throws InterruptedException {
        Thread reader = new Thread(() -> {
            while (!ready) {
                Thread.yield();
            }
            System.out.println("num: " + num);
        });
        reader.start();
        ready = true;
        Thread.sleep(100);
        num = 22;
    }
}
