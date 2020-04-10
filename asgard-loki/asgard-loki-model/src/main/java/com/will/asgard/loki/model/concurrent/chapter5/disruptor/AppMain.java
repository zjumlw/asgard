package com.will.asgard.loki.model.concurrent.chapter5.disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * @ClassName AppMain
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 20:10
 * @Version 1.0
 **/
public class AppMain {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		PCDataFactory factory = new PCDataFactory();
		int buffersize = 1024;

		Disruptor<PCData> disruptor = new Disruptor<PCData>(
				factory,
				buffersize,
				es,
				ProducerType.MULTI,
				new BlockingWaitStrategy());

		disruptor.handleEventsWithWorkerPool(
				new Consumer(),
				new Consumer(),
				new Consumer(),
				new Consumer()
		);
		disruptor.start();

		RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
		Producer producer = new Producer(ringBuffer);
		ByteBuffer bb = ByteBuffer.allocate(8);
		for (long l = 0; true; l++) {
			bb.putLong(0, l);
			producer.pushData(bb);
			Thread.sleep(100);
			System.out.println("add data " + l);
		}
	}
}
