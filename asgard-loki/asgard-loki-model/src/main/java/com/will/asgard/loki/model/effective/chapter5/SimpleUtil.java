package com.will.asgard.loki.model.effective.chapter5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SimpleUtil
 * @Description util
 * @Author maolingwei
 * @Date 2020-02-28 00:37
 * @Version 1.0
 **/
public class SimpleUtil {
	private SimpleUtil() {
	}

	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		if (s1 == null) {
			return s2;
		}
		Set<E> result = new HashSet<>(s1);
		if (s2 != null) {
			result.addAll(s2);
		}
		return result;
	}

	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<>();
	}

	private static final UnaryFunction<Object> IDENTITY_FUNCTION = o -> o;

	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}

	public static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> it = list.iterator();
		T result = it.next();
		while (it.hasNext()) {
			T t = it.next();
			if (t.compareTo(result) > 0) {
				result = t;
			}
		}
		return result;
	}
}
