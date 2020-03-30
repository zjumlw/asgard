package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TimeLock
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-30 16:46
 * @Version 1.0
 **/
public class TimeLock implements Runnable {
	private static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			if (lock.tryLock(1, TimeUnit.SECONDS)) {
				Thread.sleep(2000);
			} else {
				System.out.println(Thread.currentThread().getName() + " get lock failed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TimeLock timeLock = new TimeLock();
		Thread t1 = new Thread(timeLock);
		Thread t2 = new Thread(timeLock);
		t1.start();
		Thread.sleep(100);
		t2.start();
	}
}
