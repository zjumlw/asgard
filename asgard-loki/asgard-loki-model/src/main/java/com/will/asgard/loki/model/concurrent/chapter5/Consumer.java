package com.will.asgard.loki.model.concurrent.chapter5;

import java.text.MessageFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.will.asgard.common.util.RandomUtil;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 15:36
 * @Version 1.0
 **/
public class Consumer implements Runnable {
	private static final int SLEEPTIME = 1000;

	private BlockingQueue<PCData> queue;

	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("Start consumer id=" + Thread.currentThread().getId());
		try {
			for (; ; ) {
				PCData data = queue.take();
				if (null != data) {
					int re = data.getIntData() * data.getIntData();
					System.out.println(MessageFormat.format("{0}*{1}={2}",
							data.getIntData(), data.getIntData(), re));
					Thread.sleep(RandomUtil.nextInt(SLEEPTIME));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Consumer consumer = new Consumer(new LinkedBlockingDeque<>(10));
	}
}
