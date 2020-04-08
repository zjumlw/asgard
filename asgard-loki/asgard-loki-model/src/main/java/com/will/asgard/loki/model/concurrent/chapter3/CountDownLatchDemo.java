package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CountDownLatchDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-07 18:49
 * @Version 1.0
 **/
public class CountDownLatchDemo implements Runnable {
	private static final CountDownLatch end = new CountDownLatch(10);

	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(10) * 1000);
			System.out.println("check complete");
			end.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		CountDownLatchDemo demo = new CountDownLatchDemo();
		for (int i = 0; i < 10; i++) {
			exec.submit(demo);
		}

		end.await();
		System.out.println("Fire");
		exec.shutdown();
	}
}
