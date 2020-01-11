package com.will.asgard.admin.demo.volatiledemo;

/**
 * Created by WillMao on 18-8-29
 */
public class HappensBeforeDemo {
	private static int k;
	private static int j;

	private static class AssignK1 implements Runnable {

		@Override
		public void run() {
			k = 1;
		}
	}

	private static class AssignK2 implements Runnable {

		@Override
		public void run() {
			k = 2;
		}
	}

	private static class AssignJ implements Runnable {

		@Override
		public void run() {
			j = k;
		}
	}

	public static void main(String[] args) throws Throwable {
		Thread threadA = new Thread(new AssignK1());
		Thread threadB = new Thread(new AssignK2());
		Thread threadC = new Thread(new AssignJ());
		threadA.start();
		threadC.start();
		threadB.start();
		Thread.sleep(500);
		System.out.println("k = " + k + ", j = " + j);
	}
}
