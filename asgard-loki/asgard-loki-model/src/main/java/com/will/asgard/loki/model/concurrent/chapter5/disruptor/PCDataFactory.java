package com.will.asgard.loki.model.concurrent.chapter5.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @ClassName PCDataFactory
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 20:05
 * @Version 1.0
 **/
public class PCDataFactory implements EventFactory<PCData> {

	@Override
	public PCData newInstance() {
		return new PCData();
	}
}
