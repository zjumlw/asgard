package com.will.asgard.loki.model.concurrency.chapter6;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-07 11:53 下午
 * @Version 1.0
 */
public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            // 允许线程退出
        }
    }

    public void cancel() {
        interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(5000);
                long end = System.currentTimeMillis();
            } catch (InterruptedException e) {
                long interruptedTime = System.currentTimeMillis();
                System.out.println("Thread t1 is interrupted at " + interruptedTime);
                System.out.println("Thread t1 is interrupted after starting for " + (interruptedTime - start) + " ms");
            }
        });

        t1.start();
        Thread.sleep(1000);
        System.out.println("Interrupt t1 at " + System.currentTimeMillis());
        t1.interrupt();
    }
}
