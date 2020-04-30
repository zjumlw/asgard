package com.will.asgard.loki.model.cache;

import java.util.ArrayList;
import java.util.List;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @ClassName BloomFilterDemo
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-29 20:26
 * @Version 1.0
 **/
public class BloomFilterDemo {

	private static final int SIZE = 1000000;

	public static void main(String[] args) {
		BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), SIZE, 0.1);
		for (int i = 0; i < SIZE; i++) {
			bloomFilter.put(i);
		}

		List<Integer> out = new ArrayList<>();
		for (int i = SIZE + 1000; i < SIZE + 2000; i++) {
			if (bloomFilter.mightContain(i)) {
				out.add(i);
			}
		}

		System.out.println(out.size());
	}
}
