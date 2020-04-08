package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-07 17:03
 * @Version 1.0
 **/
public class SemaphoreDemo implements Runnable {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(20);
		final SemaphoreDemo demo = new SemaphoreDemo();
		for (int i = 0; i < 20; i++) {
			exec.submit(demo);
		}
	}

	private final Semaphore semp = new Semaphore(5);

	@Override
	public void run() {
		try {
			semp.acquire();
			Thread.sleep(200);
			System.out.println(Thread.currentThread().getName() + " done");
			semp.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
