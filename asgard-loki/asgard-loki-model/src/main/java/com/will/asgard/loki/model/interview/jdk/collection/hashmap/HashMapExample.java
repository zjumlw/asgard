package com.will.asgard.loki.model.interview.jdk.collection.hashmap;

/**
 * @ClassName HashMapExample
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-03-27 16:34
 * @Version 1.0
 **/
public class HashMapExample {
	private static final int MAXIMUM_CAPACITY = 1 << 30;

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

	public static void main(String[] args) {

	}

}
