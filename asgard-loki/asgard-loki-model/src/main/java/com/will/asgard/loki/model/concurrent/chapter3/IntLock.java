package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName IntLock
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-30 16:04
 * @Version 1.0
 **/
public class IntLock implements Runnable {

	private static ReentrantLock lock1 = new ReentrantLock();
	private static ReentrantLock lock2 = new ReentrantLock();
	private int lock;

	public IntLock(int lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			if (lock == 1) {
				lock1.lockInterruptibly();
				Thread.sleep(200);
				lock2.lockInterruptibly();
			} else {
				lock2.lockInterruptibly();
				Thread.sleep(200);
				lock1.lockInterruptibly();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if (lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
			System.out.println(Thread.currentThread().getName() + " exit");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		IntLock lock1 = new IntLock(1);
		IntLock lock2 = new IntLock(2);
		Thread t1 = new Thread(lock1);
		t1.setName("first");
		Thread t2 = new Thread(lock2);
		t2.setName("second");
		t1.start();
		t2.start();
		Thread.sleep(500);
		t2.interrupt();
	}
}
