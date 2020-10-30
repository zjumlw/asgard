package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.concurrent.GuardedBy;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-20 10:40 下午
 * @Version 1.0
 */
class Chapter5Main {

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 100000;
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        for (int i = 0; i < 10; i++) {
            int ans = runTask(executorService, nThreads);
            System.out.println("idx: " + i + ", ans: " + ans);
            if (ans != nThreads) {
                System.out.println("Not Equal");
            }
        }

        executorService.shutdown();
    }

    private static int runTask(ExecutorService executorService, int nThreads) throws InterruptedException {
        GuardByThing thing = new GuardByThing();
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            executorService.submit(() -> {
                try {
//                    System.out.println(Thread.currentThread().getName() + " waiting for start gate");
                    startGate.await();
//                    System.out.println(Thread.currentThread().getName() + " update num");
                    thing.updateNum();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    endGate.countDown();
//                    System.out.println(Thread.currentThread().getName() + "count down end gate");
                }
            });
        }

//        System.out.println("start gate is open");
        startGate.countDown();
//
        endGate.await();
//        System.out.println("all tasks are done");

        int ret = thing.getNum();
        return ret;
    }

    @Getter
    @Setter
    private static class GuardByThing {
        @GuardedBy("this") // 这个注解只是做个标记作用，没有实际效力
        private int num;

        public synchronized void updateNum() {
            num++;
        }
    }
}
