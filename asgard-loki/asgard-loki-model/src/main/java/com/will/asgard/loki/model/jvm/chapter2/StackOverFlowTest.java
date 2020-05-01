package com.will.asgard.loki.model.jvm.chapter2;

/**
 * @ClassName StackOverFlowTest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-30 21:47
 * @Version 1.0
 **/
public class StackOverFlowTest {

	private int val = 0;

	public void test() {
		val++;
		// -Xss228k的情况下，没有a val=1495，有a val=1371
		// 因为本地变量进到栈帧，占据了部分内存空间，在栈容量不变的情况下，栈深度减少
		int a = 10;
		test();
	}

	public static void main(String[] args) {
		StackOverFlowTest test = new StackOverFlowTest();
		try {
			test.test();
		} catch (Throwable th) {

		}
		System.out.println(test.val);
	}
}
