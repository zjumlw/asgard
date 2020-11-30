package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-11-27 14:39
 * @Version 1.0
 **/
public class BoundedBuffer<T> {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            // 已经满了，阻塞等待直到不满
            while (count == items.length) {
                System.out.println("items is full");
                notFull.await();
            }
            items[putptr] = x;
            // 数组超下标，回到头部
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            // 加进去了，肯定有数据，通知不空了
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            // 数组空了，阻塞等待直到不空
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takeptr];
            // 指针到数组末尾了，回到头部
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            // 拿出一个，肯定不满，通知不满了
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer<String> boundedBuffer = new BoundedBuffer<>();

        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                try {
                    System.out.println("put " + i);
                    boundedBuffer.put(i + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(500);

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    String take = boundedBuffer.take();
                    System.out.println("take " + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
