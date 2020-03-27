package com.will.asgard.loki.model.concurrent.chapter2;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @ClassName HashMapMultiThread
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 02:43
 * @Version 1.0
 **/
public class HashMapMultiThread {
	private static Map<String, String> map = Maps.newHashMap();

	private static class AddThread implements Runnable {
		private int start;

		public AddThread(int start) {
			this.start = start;
		}

		@Override
		public void run() {
			for (int i = start; i < 10000; i = i + 2) {
				map.put(Integer.toString(i), Integer.toBinaryString(i));
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AddThread(0));
		Thread t2 = new Thread(new AddThread(1));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map.size());
	}
}
