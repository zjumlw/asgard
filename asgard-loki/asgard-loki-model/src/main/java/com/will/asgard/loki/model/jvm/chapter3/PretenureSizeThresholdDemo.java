package com.will.asgard.loki.model.jvm.chapter3;

/**
 * @ClassName PretenureSizeThresholdDemo
 * @Description
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 *  -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
 * @Author maolingwei
 * @Date 2020-05-01 19:55
 * @Version 1.0
 **/
public class PretenureSizeThresholdDemo {

	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		byte[] a = new byte[4 * _1MB];
	}
}
