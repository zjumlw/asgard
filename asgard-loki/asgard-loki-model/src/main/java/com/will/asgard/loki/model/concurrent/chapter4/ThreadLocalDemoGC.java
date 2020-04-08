package com.will.asgard.loki.model.concurrent.chapter4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadLocalDemoGC
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-09 01:26
 * @Version 1.0
 **/
public class ThreadLocalDemoGC {
	private static volatile ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected void finalize() throws Throwable {
			System.out.println(this.toString() + " is gc");
		}
	};

	private static volatile CountDownLatch cd = new CountDownLatch(10000);

	private static class ParseDate implements Runnable {
		int i = 0;

		public ParseDate(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			try {
				if (tl.get() == null) {
					tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
						@Override
						protected void finalize() throws Throwable {
							System.out.println(this.toString() + " is gc");
						}
					});
					System.out.println(Thread.currentThread().getId() + " : create SimpleDateFormat");
				}
				Date t = tl.get().parse("2020-04-09 01:31:" + i % 60);
			} catch (ParseException e) {
				e.printStackTrace();
			} finally {
				cd.countDown();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10000; i++) {
			es.execute(new ParseDate(i));
		}

		cd.await();
		System.out.println("mission complete");

		tl = null;
		System.gc();
		System.out.println("first GC complete");

		tl = new ThreadLocal<>();
		cd = new CountDownLatch(10000);
		for (int i = 0; i < 10000; i++) {
			es.execute(new ParseDate(i));
		}
		cd.await();
		Thread.sleep(500);
		System.gc();
		System.out.println("second GC complete");
	}
}
