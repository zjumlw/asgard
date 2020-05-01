package com.will.asgard.loki.model.jvm.chapter3;

/**
 * @ClassName MinorGCDEMO
 * @Description
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 * @Author maolingwei
 * @Date 2020-05-01 19:06
 * @Version 1.0
 **/
public class MinorGCDemo {

	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		boolean[] a1 = new boolean[2 * _1MB];
		boolean[] a2 = new boolean[2 * _1MB];
		boolean[] a3 = new boolean[2 * _1MB];
		boolean[] a4 = new boolean[4 * _1MB];
		System.gc();
	}
}
