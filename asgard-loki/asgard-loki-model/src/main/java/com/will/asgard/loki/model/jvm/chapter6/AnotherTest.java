package com.will.asgard.loki.model.jvm.chapter6;

/**
 * @ClassName AnotherTest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-02 03:12
 * @Version 1.0
 **/
public class AnotherTest {
	public int inc() {
		int x;
		try {
			x = 1;
			return x;
		} catch (Exception e) {
			x = 2;
			return x;
		} finally {
			x = 3;
		}
	}

	public static void main(String[] args) {
		double n = 1.0;
		double m = 0.0;
		System.out.println((int) (n / m));
		System.out.println((long) (n / m));
	}
}
