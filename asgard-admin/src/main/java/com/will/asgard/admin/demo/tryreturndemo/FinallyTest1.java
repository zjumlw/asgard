package com.will.asgard.admin.demo.tryreturndemo;

/**
 * Created by WillMao on 18-10-19
 *
 * 查看先执行return还是先执行finally
 */
public class FinallyTest1 {

	public static void main(String[] args) {
		System.out.println("main");
		System.out.println(test4());
	}

	private static int test1() {
		int b = 20;
		try {
			System.out.println("try block");
			return b += 20;
		} catch (Exception e) {
			System.out.println("catch block");
		} finally {

			System.out.println("finally block");
			b = 11;
			if (b > 25) {
				System.out.println("b>25, b = " + b);
			}

		}
		return b;
	}

	public static int test4() {
		int b = 20;

		try {
			System.out.println("try block");

			b = b / 0;

			return b += 80;
		} catch (Exception e) {

			b += 15;
			System.out.println("catch block");
		} finally {

			System.out.println("finally block");

			if (b > 25) {
				System.out.println("b>25, b = " + b);
			}

			b += 50;
		}

		return b;
	}

}
