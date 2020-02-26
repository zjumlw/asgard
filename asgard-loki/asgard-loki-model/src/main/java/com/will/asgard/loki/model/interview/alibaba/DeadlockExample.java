package com.will.asgard.loki.model.interview.alibaba;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName DeadlockExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-26 11:23
 * @Version 1.0
 **/
public class DeadlockExample {

	static boolean thread1GetLock2 = false;
	static boolean thread2GetLock1 = false;

	public static void main(String[] args) throws Exception {
		InternalLock lock1 = new InternalLock("lock1");
		InternalLock lock2 = new InternalLock("lock2");
		boolean blocking = true;



		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread1 run");
				synchronized (lock1) {
					System.out.println("thread1 get lock1");
					try {
						System.out.println("thread1 sleep 100 ms");
						Thread.sleep(100);
						System.out.println("thread1 awake");
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println("thread1 get lock2");
						thread1GetLock2 = true;
					}
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread2 run");
				synchronized (lock2) {
					System.out.println("thread2 get lock2");
					try {
						System.out.println("thread2 sleep 100 ms");
						Thread.sleep(100);
						System.out.println("thread2 awake");
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (lock1) {
						System.out.println("thread2 get lock1");
						thread2GetLock1 = true;
					}
				}
			}
		});

		thread1.start();
		thread2.start();

		while (blocking) {
			System.out.println("blocking");
			if (thread2GetLock1 && thread1GetLock2) {
				System.out.println("free");
				blocking = false;
			}
			Thread.sleep(100);
		}
	}

	@Getter
	@AllArgsConstructor
	private static class InternalLock {
		private String name;
	}
}
