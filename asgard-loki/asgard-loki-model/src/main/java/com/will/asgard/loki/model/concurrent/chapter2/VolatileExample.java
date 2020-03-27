package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName VolatileExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 01:06
 * @Version 1.0
 **/
public class VolatileExample {
	private static volatile long cnt = 0;

	private static class PlusTask implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				synchronized (this) {
					// lock or use atomic class
					cnt++;
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new PlusTask());
			threads[i].start();
		}

		for (int i = 0; i < 10; i++) {
			threads[i].join();
		}

		System.out.println(cnt);
	}
}
