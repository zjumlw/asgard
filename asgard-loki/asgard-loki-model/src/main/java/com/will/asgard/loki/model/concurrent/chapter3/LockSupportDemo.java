package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LockSupportDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-07 21:03
 * @Version 1.0
 **/
public class LockSupportDemo {
	private static Object u = new Object();
	private static class ChangeObjectThread extends Thread {
		public ChangeObjectThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			synchronized (u) {
				System.out.println("in " + getName());
				LockSupport.park();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ChangeObjectThread t1 = new ChangeObjectThread("t1");
		ChangeObjectThread t2 = new ChangeObjectThread("t2");

		t1.start();
		Thread.sleep(100);
		t2.start();
		LockSupport.unpark(t1);
		LockSupport.unpark(t2);

		t1.join();
		t2.join();
	}
}
