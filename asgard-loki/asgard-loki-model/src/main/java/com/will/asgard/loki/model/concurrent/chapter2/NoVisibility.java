package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName NoVisibility
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 01:28
 * @Version 1.0
 **/
public class NoVisibility {
	private static volatile boolean ready;
	private static int number;

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!ready) {

				}
				System.out.println(number);
			}
		}).start();
		Thread.sleep(100);
		ready = true;
		number = 10;
		Thread.sleep(100);
	}
}
