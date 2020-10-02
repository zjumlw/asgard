package com.will.asgard.loki.model.concurrency.chapter4;

import javax.annotation.concurrent.GuardedBy;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-01 8:17 下午
 * @Version 1.0
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    private String name;

    public void showName() {
        System.out.println("等待获取内部锁");
        synchronized (myLock) {
            System.out.println("已获取到内部锁");
            System.out.println("名字是" + name);
            System.out.println("稍等500ms");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("释放内部锁");
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        PrivateLock lock = new PrivateLock();
        lock.setName("我是一把锁");

        for (int i = 0; i < 10; i++) {
            lock.showName();
            lock.setName("lock-" + i);
        }
    }
}
