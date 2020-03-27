package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName BadSuspend
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-26 23:47
 * @Version 1.0
 **/
public class BadSuspend {
	private static final Object object = new Object();
	private static class SuspendThread extends Thread {
		public SuspendThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			synchronized (object) {
				System.out.println(getName() + " get object lock");
				System.out.println("in " + getName());
				Thread.currentThread().suspend();
			}
			System.out.println(getName() + " release object lock");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new SuspendThread("t1");
		Thread t2 = new SuspendThread("t2");

		t1.start();
		Thread.sleep(100);
		t2.start();

		System.out.println("After sleep 100 ms");

		System.out.println("before t1 resume");
		t1.resume();
		System.out.println("after t1 resume");

		System.out.println("before t2 resume");
		t2.resume();
		System.out.println("after t2 resume");

//
//		t1.join();
//		t2.join();
	}
}
