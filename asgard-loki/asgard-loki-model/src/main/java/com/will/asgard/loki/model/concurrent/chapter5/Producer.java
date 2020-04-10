package com.will.asgard.loki.model.concurrent.chapter5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.will.asgard.common.util.RandomUtil;

/**
 * @ClassName Producer
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 15:11
 * @Version 1.0
 **/
public class Producer implements Runnable {
	private static AtomicInteger count = new AtomicInteger();
	private static final int SLEEPTIME = 1000;

	private volatile boolean isRunning = true;
	private BlockingQueue<PCData> queue;

	public Producer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		PCData data = null;
		System.out.println("Start producer id=" + Thread.currentThread().getId());

		try {
			while (isRunning) {
				Thread.sleep(RandomUtil.nextInt(SLEEPTIME));
				data = new PCData(count.incrementAndGet());
				System.out.println(data + " is put into queue");
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.out.println("failed to put data: " + data);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public void stop() {
		isRunning = false;
	}
}
