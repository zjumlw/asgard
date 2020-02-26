package com.will.asgard.loki.model.effective.chapter4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentedHashSetTest {

	@Test
	public void test() {
		Set<String> set = new HashSet<>();
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>(set);
		s.add("Snap");
		s.add("Pop");
		s.addAll(Arrays.asList("Hello"));

		System.out.println(s.getAddCount());
	}
}