package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName GoodSuspend
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-26 23:59
 * @Version 1.0
 **/
public class GoodSuspend {
	private static final Object lock = new Object();

	private static class SuspendThread extends Thread {
		private volatile boolean suspend;

		public void suspendMe() {
			suspend = true;
		}

		public void resumeMe() {
			suspend = false;
			synchronized (this) {
				notify();
			}
		}

		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					while (suspend) {
						try {
							System.out.println("before wait");
							wait();
							System.out.println("after wait");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				synchronized (lock) {
					System.out.println("in change thread");
				}
				Thread.yield();
			}
		}
	}

	private static class ReadObjectThread extends Thread {

		@Override
		public void run() {
			while (true) {
				synchronized (lock) {
					System.out.println("in read thread");
				}
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SuspendThread t1 = new SuspendThread();
		ReadObjectThread t2 = new ReadObjectThread();

		t1.start();
//		t2.start();
		Thread.sleep(100);
		System.out.println("after sleep 100ms");

		t1.suspendMe();
		System.out.println("suspend t1 2s");
		Thread.sleep(2000);

		System.out.println("resume t1");
		t1.resumeMe();

		if (!t1.suspend) {
			System.exit(0);
		}
	}
}
