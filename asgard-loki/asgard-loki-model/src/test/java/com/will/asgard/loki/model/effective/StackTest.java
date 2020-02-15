package com.will.asgard.loki.model.effective;

import org.junit.Test;

import static org.junit.Assert.*;

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
}