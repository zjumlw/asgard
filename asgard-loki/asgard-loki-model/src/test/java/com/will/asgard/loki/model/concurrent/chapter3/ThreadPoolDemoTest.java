package com.will.asgard.loki.model.concurrent.chapter3;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadPoolDemoTest {
	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int RUNNING    = -1 << COUNT_BITS;
	private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

	private static int ctlOf(int rs, int wc) { return rs | wc; }
	private static int workerCountOf(int c)  { return c & CAPACITY; }

	@Test
	public void test() {
		String capacityBin = "000" + Integer.toBinaryString(CAPACITY);
		System.out.println(capacityBin.length() + ": " + capacityBin);

		AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
		int c = ctl.get();
		String cBin = Integer.toBinaryString(c);
		System.out.println(cBin.length() + ": " + cBin);
		System.out.println(c);
		System.out.println(workerCountOf(c));

		ctl.getAndIncrement();
		c = ctl.get();
		cBin = Integer.toBinaryString(c);
		System.out.println(cBin.length() + ": " + cBin);
		System.out.println(c);
		System.out.println(workerCountOf(c));

		ctl.getAndIncrement();
		c = ctl.get();
		cBin = Integer.toBinaryString(c);
		System.out.println(cBin.length() + ": " + cBin);
		System.out.println(c);
		System.out.println(workerCountOf(c));
	}
}