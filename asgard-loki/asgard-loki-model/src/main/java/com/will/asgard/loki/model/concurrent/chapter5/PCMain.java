package com.will.asgard.loki.model.concurrent.chapter5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName PCMain
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 16:37
 * @Version 1.0
 **/
public class PCMain {
	public static void main(String[] args) throws InterruptedException {
		final BlockingQueue<PCData> queue = new LinkedBlockingQueue<>(10);
		Producer[] producers = new Producer[3];
		Consumer[] consumers = new Consumer[3];
		for (int i = 0; i < 3; i++) {
			producers[i] = new Producer(queue);
			consumers[i] = new Consumer(queue);
		}

		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			es.execute(producers[i]);
			es.execute(consumers[i]);
		}

		Thread.sleep(5 * 1000);
		for (int i = 0; i < 3; i++) {
			producers[i].stop();
		}

		Thread.sleep(3000);
		es.shutdown();
 	}
}
