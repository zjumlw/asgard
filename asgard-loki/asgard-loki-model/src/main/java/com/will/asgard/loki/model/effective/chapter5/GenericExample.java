package com.will.asgard.loki.model.effective.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;
import com.sun.security.auth.SolarisNumericGroupPrincipal;

import lombok.Data;

/**
 * @ClassName GenericExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-27 01:34
 * @Version 1.0
 **/
public class GenericExample {

	static <E> E reduce(List<E> list, Function<E> f, E initVal) {
		List<E> snapshot;
		synchronized (list) {
			snapshot = new ArrayList<>(list); // copy list
		}

		E result = initVal;
		for (E e : snapshot) {
			result = f.apply(result, e);
		}
		return result;
	}

	private interface Function<T> {
		T apply(T arg1, T arg2);
	}

	public static void main(String[] args) {
		List<Integer> list1 = Lists.newArrayList(1, 2, 3);
		List<Integer> list2 = new ArrayList<>(list1);
		List<Integer> list3 = Lists.newArrayList(list1);
		list2.add(4);
		list3.add(5);

		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}
}
