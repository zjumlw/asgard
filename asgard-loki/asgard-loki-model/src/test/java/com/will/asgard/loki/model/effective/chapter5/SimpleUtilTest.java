package com.will.asgard.loki.model.effective.chapter5;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class SimpleUtilTest {

	@Test
	public void testUnion() {
		Set<String> s1 = new HashSet<>();
		s1.add("hello");

		Set<String> s2 = new HashSet<>();
		s2.add("world");

		Set<String> s3 = SimpleUtil.union(s1, s2);
		Assert.assertTrue(s3.contains("hello") && s3.contains("world"));

		s3 = SimpleUtil.union(null, s1);
		Assert.assertTrue(s3.contains("hello"));

		s3 = SimpleUtil.union(s2, null);
		Assert.assertTrue(s3.contains("world"));

		s3 = SimpleUtil.union(null, null);
		Assert.assertEquals(null, s3);
	}

	@Test
	public void testUnion1() {
		Set<Integer> integers = Sets.newHashSet(1, 2, 3);
		Set<Double> doubles = Sets.newHashSet(1.1, 2.2, 3.3);

		Set<Number> numbers = SimpleUtil.union(integers, doubles);
		System.out.println(numbers);
	}

	@Test
	public void testHashMap() {
		Map<String, String> m1 = Maps.newHashMap();
		Map<String, String> m2 = SimpleUtil.newHashMap();
		Assert.assertEquals(m1, m2);
 	}

	@Test
	public void testIdentityFunction() {
		String[] strings = {"hello", "world", "beijing"};
		UnaryFunction<String> sameString = SimpleUtil.identityFunction();
		for (String s : strings) {
			System.out.println(sameString.apply(s));
		}

		Number[] numbers = new Number[]{1, 2, 3};
		UnaryFunction<Number> sameNumber = SimpleUtil.identityFunction();
		for (Number n : numbers) {
			System.out.println(sameNumber.apply(n));
		}
	}

	@Test
	public void testMax() {
		List<Integer> numbers = Lists.newArrayList(1, 3, 5, 7, 9);
		Integer maxNumber = SimpleUtil.max(numbers);
		Assert.assertEquals(9, maxNumber.intValue());
	}

	@Test
	public void testMax1() {
		List<ScheduledFuture<?>> scheduledFutures = Lists.newArrayList();
		// ...
	}
}