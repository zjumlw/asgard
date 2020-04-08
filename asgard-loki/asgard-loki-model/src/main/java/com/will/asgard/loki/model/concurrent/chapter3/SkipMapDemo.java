package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName SkipMapDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-08 18:16
 * @Version 1.0
 **/
public class SkipMapDemo {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new ConcurrentSkipListMap<>();
		for (int i = 0; i < 20; i++) {
			map.put(i, i);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
}
