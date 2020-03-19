package com.will.asgard.loki.model.effective.chapter10;

import org.junit.Test;

public class ConcurrentExampleTest {

	@Test
	public void testStringIntern() {
		ConcurrentExample.intern("hello");
		ConcurrentExample.internStatus();

		ConcurrentExample.intern("world");
		ConcurrentExample.internStatus();

		ConcurrentExample.intern("hello");
		ConcurrentExample.internStatus();
	}

	@Test
	public void test1() {
		ConcurrentExample concurrentExample = new ConcurrentExample();
		ConcurrentExample.FieldType field = concurrentExample.getField();
		System.out.println(field);
		System.out.println(concurrentExample.getField());
	}

	@Test
	public void test2() {
		System.out.println(ConcurrentExample.getStaticField());
		System.out.println(ConcurrentExample.getStaticField());
	}

	@Test
	public void test3() {
		ConcurrentExample concurrentExample = new ConcurrentExample();
		System.out.println(concurrentExample.getAnotherField());
		System.out.println(concurrentExample.getAnotherField());
	}
}