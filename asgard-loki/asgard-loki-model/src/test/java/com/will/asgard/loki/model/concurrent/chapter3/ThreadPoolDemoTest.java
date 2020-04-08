package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import lombok.AllArgsConstructor;

public class ThreadPoolDemoTest {
	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int RUNNING    = -1 << COUNT_BITS;
	private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

	private static int ctlOf(int rs, int wc) { return rs | wc; }
	private static int workerCountOf(int c)  { return c & CAPACITY; }

	@Test
	public void test() {
		String capacityBin = "000" + Integer.toBinaryString(CAPACITY);
		System.out.println(capacityBin.length() + ": " + capacityBin);

		AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
		int c = ctl.get();
		String cBin = Integer.toBinaryString(c);
		System.out.println(cBin.length() + ": " + cBin);
		System.out.println(c);
		System.out.println(workerCountOf(c));

		ctl.getAndIncrement();
		c = ctl.get();
		cBin = Integer.toBinaryString(c);
		System.out.println(cBin.length() + ": " + cBin);
		System.out.println(c);
		System.out.println(workerCountOf(c));

		ctl.getAndIncrement();
		c = ctl.get();
		cBin = Integer.toBinaryString(c);
		System.out.println(cBin.length() + ": " + cBin);
		System.out.println(c);
		System.out.println(workerCountOf(c));
	}


	@Test
	public void test1() throws ExecutionException, InterruptedException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			Future f = es.submit(new MyTask(100, i));
//			f.get();
		}
	}

	@Test
	public void test2() {
		ThreadPoolExecutor exec = new TraceThreadPoolExecutor(1, 1, 0,
				TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 5; i++) {
			exec.execute(new MyTask(10, i));
		}
	}

	@AllArgsConstructor
	private static class MyTask implements Runnable {
		private int a;
		private int b;

		@Override
		public void run() {
			System.out.println(a / b);
		}
	}
}