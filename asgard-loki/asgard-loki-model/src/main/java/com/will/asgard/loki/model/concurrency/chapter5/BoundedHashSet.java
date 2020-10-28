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
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                // 返回许可给信号量
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            sem.release();
        }
        return wasRemoved;
    }
}
