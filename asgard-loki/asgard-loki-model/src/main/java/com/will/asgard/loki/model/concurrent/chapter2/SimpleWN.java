package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName SimpleWN
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-26 23:37
 * @Version 1.0
 **/
public class SimpleWN {
	private static final Object object = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (object) {
					System.out.println(System.currentTimeMillis() + ":T1 start!");
					try {
						System.out.println(System.currentTimeMillis() + ":T1 wait for object");
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(System.currentTimeMillis() + ":T1 end!");
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (object) {
					System.out.println(System.currentTimeMillis() + ":T2 start! Notify one thread");
					object.notify();
					System.out.println(System.currentTimeMillis() + ":T2 end!");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
				}
			}
		});

		t1.start();
		t2.start();
	}
}
