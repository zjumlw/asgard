package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 02:56
 * @Version 1.0
 **/
public class ReentrantLockDemo implements Runnable {
	private static ReentrantLock lock = new ReentrantLock();
	private static int i = 0;

	@Override
	public void run() {
		for (int j = 0; j < 10000; j++) {
			lock.lock();
			try {
				i++;
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockDemo target = new ReentrantLockDemo();
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
