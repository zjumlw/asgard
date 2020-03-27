package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName JoinMain
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 00:13
 * @Version 1.0
 **/
public class JoinMain {
	private static volatile int i = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (i = 0; i < 10000; i++) {

				}
			}
		});
		t.start();
		t.join();
		System.out.println(i);
	}



}
