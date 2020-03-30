package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReenterLockCondition
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-30 17:11
 * @Version 1.0
 **/
public class ReenterLockCondition implements Runnable {
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();

	@Override
	public void run() {
		lock.lock();
		try {
			condition.await();
			System.out.println("Thread is going on");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLockCondition run = new ReenterLockCondition();
		Thread t1 = new Thread(run);
		t1.start();
		Thread.sleep(1000);
		lock.lock();
		condition.signal();
		lock.unlock();
	}
}
