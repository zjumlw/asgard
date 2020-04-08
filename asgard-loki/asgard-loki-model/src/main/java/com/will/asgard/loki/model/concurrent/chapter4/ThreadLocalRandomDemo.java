package com.will.asgard.loki.model.concurrent.chapter4;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName ThreadLocalRandomDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-09 01:39
 * @Version 1.0
 **/
public class ThreadLocalRandomDemo {
	private static final int GEN_COUNT = 10000000;
	private static final int THREAD_COUNT = 4;

	private static ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);
	private static Random rnd = new Random(123);
	private static ThreadLocal<Random> trnd = new ThreadLocal<Random>() {
		@Override
		protected Random initialValue() {
			return new Random(123);
		}
	};

	private static class RndTask implements Callable<Long> {
		private int mode = 0;

		public RndTask(int mode) {
			this.mode = mode;
		}

		private Random getRandom() {
			if (mode == 0) {
				return rnd;
			} else if (mode == 1) {
				return trnd.get();
			} else {
				return null;
			}
		}

		@Override
		public Long call() throws Exception {
			long start = System.currentTimeMillis();

			for (long i = 0; i < GEN_COUNT; i++) {
				getRandom().nextInt();
			}
			long end = System.currentTimeMillis();
			System.out.println(Thread.currentThread().getName() + " took " + (end - start) + "ms");
			return end - start;
		}
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Future<Long>[] futures = new Future[THREAD_COUNT];
		for (int i = 0; i < THREAD_COUNT; i++) {
			futures[i] = es.submit(new RndTask(0));
		}
		long totalTime = 0;
		for (int i = 0; i < THREAD_COUNT; i++) {
			totalTime += futures[i].get();
		}
		System.out.println("same random took total time " + totalTime + "ms");

		for (int i = 0; i < THREAD_COUNT; i++) {
			futures[i] = es.submit(new RndTask(1));
		}
		totalTime = 0;
		for (int i = 0; i < THREAD_COUNT; i++) {
			totalTime += futures[i].get();
		}
		System.out.println("thread local random took total time " + totalTime + "ms");

		es.shutdown();
	}
}
