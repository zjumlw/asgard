package com.will.asgard.loki.model.jvm.chapter3;

/**
 * @ClassName ReferenceCountingGC
 * @Description
 * VM Args: -XX:+PrintGCDetails
 * @Author maolingwei
 * @Date 2020-05-01 15:25
 * @Version 1.0
 **/
public class ReferenceCountingGC {
	private static final int _1MB = 1024 * 1024;

	private Object instance = null;

	public ReferenceCountingGC() {
		byte[] bigSize = new byte[2 * _1MB];
	}

	public static void main(String[] args) {
		ReferenceCountingGC o1 = new ReferenceCountingGC();
		ReferenceCountingGC o2 = new ReferenceCountingGC();
		o1.instance = o2;
		o2.instance = o1;

		o1 = null;
		o2 = null;

		System.gc();
	}
}
