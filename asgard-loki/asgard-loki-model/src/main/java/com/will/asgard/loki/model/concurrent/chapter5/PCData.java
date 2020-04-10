package com.will.asgard.loki.model.concurrent.chapter5;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName PCData
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-10 15:11
 * @Version 1.0
 **/
public class PCData {
	public PCData(int intData) {
		this.intData = intData;
	}

	@Getter
	@Setter
	private final int intData;

	@Override
	public String toString() {
		return "PCData{" +
				"intData=" + intData +
				'}';
	}
}
