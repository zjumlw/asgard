package com.will.asgard.loki.model.concurrent.chapter5.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 20:02
 * @Version 1.0
 **/
public class Consumer implements WorkHandler<PCData> {
	@Override
	public void onEvent(PCData event) throws Exception {
		System.out.println(Thread.currentThread().getId() + ":Event: --" + event.get() * event.get() + "--");
	}
}
