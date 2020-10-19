package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.HashSet;
import java.util.Set;

import com.will.asgard.common.util.RandomUtil;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-10-16 16:19
 * @Version 1.0
 **/
public class HiddenIterator {

	private final Set<Integer> set = new HashSet<>();

	public synchronized void add(Integer integer) {
		set.add(integer);
	}

	public synchronized void remove(Integer integer) {
		set.remove(integer);
	}

	public void addTenThings() {
		for (int i = 0; i < 10; i++) {
			add(RandomUtil.nextInt());
		}
		System.out.println("added ten elements to " + set);
	}

	public static void main(String[] args) {
		HiddenIterator hiddenIterator = new HiddenIterator();
		for (int i = 0; i < 100; i++) {
			new Thread(() -> hiddenIterator.addTenThings()).start();
		}
	}
}
