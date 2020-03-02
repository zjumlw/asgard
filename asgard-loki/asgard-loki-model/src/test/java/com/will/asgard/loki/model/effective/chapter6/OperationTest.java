package com.will.asgard.loki.model.effective.chapter6;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {

	@Test
	public void test() {
		double x = 1.23;
		double y = 4.56;

		for (Operation op : Operation.values()) {
			System.out.printf("%f %s %f = %f%n",
					x, op, y, op.apply(x, y));
		}
	}

	@Test
	public void testFromSymbol() {
		Operation op = Operation.fromString("8");
		System.out.println(op);
	}
}