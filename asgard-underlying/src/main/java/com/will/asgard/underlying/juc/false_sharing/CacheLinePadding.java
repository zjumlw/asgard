package com.will.asgard.underlying.juc.false_sharing;

import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-04-14 上午10:11
 * @Version 1.0
 */
public class CacheLinePadding {

	private static long COUNT = 10_0000_0000L;

	private static class T {
		private long p1, p2, p3, p4, p5, p6, p7;
		public long x = 0L;
		private long p9, p10, p11, p12, p13, p14, p15;
	}

	private static T[] arr = new T[2];
	static {
		arr[0] = new T();
		arr[1] = new T();
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);

		Thread t1 = new Thread(() -> {
			for (long i = 0; i < COUNT; i++) {
				arr[0].x = i;
			}
			latch.countDown();
		});

		Thread t2 = new Thread(() -> {
			for (long i = 0; i < COUNT; i++) {
				arr[1].x = i;
			}
			latch.countDown();
		});

		long start = System.nanoTime();
		t1.start();
		t2.start();
		latch.await();
		System.out.println((System.nanoTime() - start)/100_0000);
	}
}
