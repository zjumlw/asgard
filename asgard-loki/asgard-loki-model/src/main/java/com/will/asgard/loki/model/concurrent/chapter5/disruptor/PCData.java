package com.will.asgard.loki.model.concurrent.chapter5.disruptor;

/**
 * @ClassName PCData
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 20:01
 * @Version 1.0
 **/
public class PCData {
	private long value;

	public void set(long value) {
		this.value = value;
	}

	public long get() {
		return value;
	}
}
