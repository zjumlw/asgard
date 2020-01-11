package com.will.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.util.Assert;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by WillMao on 19-2-26
 */
@Slf4j
public class StreamTest {

	@Test
	public void testListElementCnt() {
		List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);
		long cnt = nums.stream().filter(Objects::nonNull).count();
		System.out.println(cnt);
	}

	@Test
	public void testStreamOf() {
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
		Stream<String> stringStream = Stream.of("xiaomi");
	}

	@Test
	public void testStreamGenerator() {
		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		// Lambda形式
		Stream.generate(() -> Math.random());
		Stream.generate(Math::random);
	}

	@Test
	public void testCombination() {
		List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
		System.out.println("sum is:" + nums.stream().filter(Objects::nonNull).distinct().mapToInt(num -> num * 2)
				.peek(System.out::println).skip(2).limit(4).sum());
	}

	@Test
	public void testReduce() {
		List<Integer> ints = Lists.newArrayList(1, 2, 3, 4);
		System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());

		ints.stream().reduce((acc, element) -> acc - element).ifPresent(System.out::println);

	}

	@Test
	public void testMax() {
		List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int max = ints.stream().max(Comparator.comparing(number -> number)).get();
		Assert.isTrue(max == 10);

		List<Integer> biggerThenFive = ints.stream().filter(x -> x > 5).collect(Collectors.toList());
		Assert.isTrue(biggerThenFive.equals(Lists.newArrayList(6, 7, 8, 9, 10)));
	}

}
