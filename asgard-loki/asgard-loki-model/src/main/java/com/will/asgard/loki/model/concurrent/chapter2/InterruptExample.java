package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName InterruptExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-26 23:01
 * @Version 1.0
 **/
public class InterruptExample {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted!");
						break;
					}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						System.out.println("Interrupted When Sleep");
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}

			}
		});

		t1.start();
		Thread.sleep(200);
		t1.interrupt();
		System.out.println("interrupt t1");
	}
}
