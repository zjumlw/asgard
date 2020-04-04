package com.will.asgard.loki.model.interview.jdk.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @ClassName HashMapExampleTest
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-03-27 17:25
 * @Version 1.0
 **/
public class HashMapExampleTest {

	@Test
	public void test() {
		for (int i = 10; i < 10000000; i *= 10) {
			doTest(i);
		}
	}

	private void doTest(int mapSize) {
		Map<Key, Integer> map = new HashMap<>(mapSize);
		for (int i = 0; i < mapSize; i++) {
			map.put(Keys.of(i), i);
		}

		long beginTime = System.nanoTime();
		for (int i = 0; i < mapSize; i++) {
			map.get(Keys.of(i));
		}
		long endTime = System.nanoTime();
		long total = endTime - beginTime;
		long average = total / mapSize;
		System.out.println(mapSize + " : " + average);
	}

	private static class Keys {
		public static final int MAX_KEY = 10000000;
		private static final Key[] KEYS_CACHE = new Key[MAX_KEY];

		static {
			for (int i = 0; i < MAX_KEY; i++) {
				KEYS_CACHE[i] = new Key(i);
			}
		}

		static Key of(int value) {
			return KEYS_CACHE[value];
		}
	}

	private static class Key implements Comparable<Key> {
		private final int value;

		public Key(int value) {
			this.value = value;
		}

		@Override
		public int compareTo(Key o) {
			return Integer.compare(this.value, o.value);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || getClass() != obj.getClass()) {
				return false;
			}
			Key key = (Key) obj;
			return value == ((Key) obj).value;
		}

		@Override
		public int hashCode() {
			return value; // 改变成1为很差的hashcode值
		}
	}
}