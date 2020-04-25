package com.will.asgard.loki.model.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName StreamDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-21 23:32
 * @Version 1.0
 **/
public class StreamDemo {

	public static void main(String[] args) {
		String[] words = new String[]{"Hello","World"};

		List<String> a = Arrays.stream(words)
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());
		a.forEach(System.out::println);
	}
}
