package com.will.asgard.loki.model.concurrent.chapter2;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @ClassName ArrayListMultiThread
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-27 02:39
 * @Version 1.0
 **/
public class ArrayListMultiThread {
	private static List<Integer> list = Lists.newArrayList();

	private static class AddThread implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				list.add(i);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AddThread());
		Thread t2 = new Thread(new AddThread());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(list.size());
	}

}
