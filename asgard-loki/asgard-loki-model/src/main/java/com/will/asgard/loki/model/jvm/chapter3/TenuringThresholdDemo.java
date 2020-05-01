package com.will.asgard.loki.model.jvm.chapter3;

/**
 * @ClassName TenuringThresholdDemo
 * @Description
 * VM Args:  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1
 * @Author maolingwei
 * @Date 2020-05-01 20:02
 * @Version 1.0
 **/
public class TenuringThresholdDemo {
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		byte[] a1 = new byte[_1MB / 4];
		byte[] a2 = new byte[_1MB * 4];
		byte[] a3 = new byte[_1MB * 4];
		a3 = null;
		a3 = new byte[_1MB * 4];
	}
}
