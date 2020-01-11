package com.will.asgard.admin.demo.volatiledemo;

import java.util.concurrent.TimeUnit;

/**
 * Created by WillMao on 18-8-28
 */
public class StopDemo {
	private static volatile boolean stopRequest;

	public static void main(String[] args) throws Throwable {
		Thread backgroundThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (!stopRequest) {

				}
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);

		stopRequest = true;
	}
}
