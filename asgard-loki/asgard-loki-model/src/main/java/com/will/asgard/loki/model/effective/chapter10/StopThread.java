package com.will.asgard.loki.model.effective.chapter10;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName StopThread
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-16 23:44
 * @Version 1.0
 **/
public class StopThread {
	private static volatile boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
				}
			}
		});
		t.start();

		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
