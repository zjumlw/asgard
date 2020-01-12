package com.will.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.util.Assert;

import com.google.common.collect.Lists;

/**
 * Created by WillMao on 19-2-27
 */
public class StreamMapTest {

	@Test
	public void testMap() {
		List<String> collected = Lists.newArrayList();
		for (String str : Arrays.asList("a", "b", "hello")) {
			collected.add(str.toUpperCase());
		}
		Assert.isTrue(collected.equals(Lists.newArrayList("A", "B", "HELLO")));

		List<String> collected2 = Lists.newArrayList("d", "e", "ok").stream().map(String::toUpperCase)
				.collect(Collectors.toList());
		Assert.isTrue(collected2.equals(Lists.newArrayList("D", "E", "OK")));
	}

	@Test
	public void testFlatMap() {
		List<Integer> together = Stream.of(Lists.newArrayList(1, 6), Lists.newArrayList(3, 4))
				.flatMap(Collection::stream).collect(Collectors.toList());
		Assert.isTrue(together.equals(Lists.newArrayList(1, 6, 3, 4)));
	}

}
