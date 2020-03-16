package com.will.asgard.loki.model.effective.chapter6;

import java.util.EnumMap;
import java.util.EnumSet;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {

	@Test
	public void test1() {
		EnumMap<Color, String> m = new EnumMap<Color, String>(Color.class);
		m.put(Color.BLACK, "黑色");
		m.put(Color.BLUE, "蓝色");
		m.put(Color.PURPLE, null);
		m.put(Color.PURPLE, null);
		System.out.println(m.size());

		System.out.println(m);
		String res1 = m.get(Color.PURPLE);
		System.out.println(res1);
	}

	@Test
	public void test2() {
		EnumSet<Color> set = EnumSet.noneOf(Color.class);
		set.add(Color.RED);
		set.add(Color.YELLOW);

		System.out.println(set);

		EnumSet<Color> set1 = EnumSet.allOf(Color.class);
		System.out.println(set1);

		EnumSet<Color> set2 = EnumSet.range(Color.YELLOW, Color.BLUE);
		System.out.println(set2);

	}
}