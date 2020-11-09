package com.will.asgard.loki.model.concurrency.chapter6;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-08 1:50 上午
 * @Version 1.0
 */
public class ThreadJoinDemo extends Thread {
    private int i;
    private String name;
    private Thread prevThread;

    public ThreadJoinDemo(int i, String name, Thread prevThread) {
        this.i = i;
        this.name = name;
        this.prevThread = prevThread;
    }

    @Override
    public void run() {
        try {
            prevThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + name + ", num: " + i);
    }

    public static void main(String[] args) {
        Thread prevThread = Thread.currentThread();
        prevThread.setName("main");
        for (int i = 0; i < 10; i++) {
            String name = "thread-" + i;
            ThreadJoinDemo demo = new ThreadJoinDemo(i, name, prevThread);
            demo.start();
            prevThread = demo;
        }
    }
}
