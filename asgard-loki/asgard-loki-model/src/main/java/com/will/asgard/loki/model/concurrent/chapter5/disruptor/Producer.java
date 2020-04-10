package com.will.asgard.loki.model.concurrent.chapter5.disruptor;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

/**
 * @ClassName Producer
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 20:06
 * @Version 1.0
 **/
public class Producer {
	private final RingBuffer<PCData> ringBuffer;

	public Producer(RingBuffer<PCData> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void pushData(ByteBuffer byteBuffer) {
		long sequence = ringBuffer.next();
		try {
			PCData event = ringBuffer.get(sequence);
			event.set(byteBuffer.getLong(0));
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
