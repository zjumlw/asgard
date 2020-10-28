package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-27 10:35 下午
 * @Version 1.0
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    // 等待开始gate
                    startGate.await();
                    try {
                        // 执行任务
                        task.run();
                    } finally {
                        // 将结束gate计数减1
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) {
                    // ignore exception
                }
            });
            t.start();
        }

        long start = System.currentTimeMillis();
        // 开始gate减1，则所有线程可以执行任务
        startGate.countDown();
        // 结束gate等待计数到0，表示所有线程执行完毕了
        endGate.await();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        int threadNum = 100;
        Runnable task = () -> {
            System.out.println("task is running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task is done");
        };

        TestHarness testHarness = new TestHarness();
        long time = testHarness.timeTasks(threadNum, task);
        System.out.println(time + "ms");
    }
}
