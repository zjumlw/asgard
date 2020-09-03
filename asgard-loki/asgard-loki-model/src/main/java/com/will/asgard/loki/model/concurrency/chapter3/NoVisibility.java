package com.will.asgard.loki.model.concurrency.chapter3;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-02 10:16 下午
 * @Version 1.0
 */
class NoVisibility {
    private static int number = 0;
    private static boolean ready = false;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
