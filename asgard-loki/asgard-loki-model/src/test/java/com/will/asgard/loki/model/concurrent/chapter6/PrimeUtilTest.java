package com.will.asgard.loki.model.concurrent.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

import com.will.asgard.common.util.CommonUtil;
import com.will.asgard.common.util.RandomUtil;

public class PrimeUtilTest {
	@Test
	public void test() {
		long start = CommonUtil.getCurrentTimestamp();
		long count = IntStream.range(0, 1000000).filter(PrimeUtil::isPrime).count();
		long end = CommonUtil.getCurrentTimestamp();
		System.out.println("count=" + count + ",took " + (end - start) + "ms");
	}

	@Test
	public void test1() {
		long start = CommonUtil.getCurrentTimestamp();
		long count = IntStream.range(0, 1000000).parallel().filter(PrimeUtil::isPrime).count();
		long end = CommonUtil.getCurrentTimestamp();
		System.out.println("count=" + count + ",took " + (end - start) + "ms");
	}

	@Test
	public void testSort() {
		int[] arr = new int[100];
		Arrays.parallelSetAll(arr, i -> RandomUtil.nextInt());

		int[] tmp1 = Arrays.copyOf(arr, 100);
		int[] tmp2 = Arrays.copyOf(arr, 100);

		long start = System.nanoTime();
		Arrays.sort(tmp1);
		long end = System.nanoTime();
		System.out.println("took " + (end - start) + "ns");

//		Arrays.stream(tmp1).forEach(System.out::println);
//		Arrays.stream(tmp2).forEach(System.out::println);

		start = System.nanoTime();
		Arrays.parallelSort(tmp2);
		end = System.nanoTime();
		System.out.println("took " + (end - start) + "ns");

	}
}