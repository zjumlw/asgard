package com.will.asgard.loki.model.effective;

import java.util.Collection;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.will.asgard.loki.model.effective.chapter5.Stack;

public class StackTest {

	@Test
	public void test() {
		Stack stack = new Stack();
		for (int i = 0; i <= 15; i++) {
			stack.push("A_" + i);
		}
		stack.status();

		stack.push("B_0");
		stack.status();

		stack.pop();
		stack.status();

		Object[] elements = stack.getElements();
		System.out.println(elements[16]);
	}

	@Test
	public void testPushAll() {
		Stack<Number> numberStack = new Stack<>();
		Iterable<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
		numberStack.pushAll(integers);

		numberStack.status();

		Collection<Object> dst = Lists.newArrayList();
		numberStack.popAll(dst);
		System.out.println(dst);
	}
}