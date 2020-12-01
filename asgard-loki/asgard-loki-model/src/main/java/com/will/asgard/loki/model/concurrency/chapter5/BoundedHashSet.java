package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-28 19:21
 * @Version 1.0
 **/
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        // 阻塞直到有许可
        System.out.println(o + " try to acquire permit");
        sem.acquire();
        System.out.println(o + " success acquire permit");
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                // 返回许可给信号量
                System.out.println(o + " add failed, release permit");
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            System.out.println(o + " release permit");
            sem.release();
        } else {
            System.out.println(o + " remove failed");
        }
        return wasRemoved;
    }

    public int size() {
        return set.size();
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet<Integer> boundedHashSet = new BoundedHashSet<>(10);
        for (int i = 0; i < 20; i++) {
            final int num = i;
            new Thread(() -> {
                try {
                    boundedHashSet.add(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            final int num = i;
            new Thread(() -> boundedHashSet.remove(num)).start();
        }

        System.out.println("size: " + boundedHashSet.size());
    }
}
