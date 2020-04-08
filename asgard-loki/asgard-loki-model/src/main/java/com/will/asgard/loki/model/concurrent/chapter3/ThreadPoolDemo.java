package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPoolDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-07 22:32
 * @Version 1.0
 **/
public class ThreadPoolDemo {
	private static class MyTask implements Runnable {

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis() + ":Thread Id:" + Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			es.submit(myTask);
		}
	}
}
