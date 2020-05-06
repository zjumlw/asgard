package com.will.asgard.loki.model.jvm.jmm;

/**
 * @ClassName MyRunnable
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-03 02:23
 * @Version 1.0
 **/
public class MyRunnable implements Runnable {
	@Override
	public void run() {
		methodOne();
	}

	public void methodOne() {
		int var1 = 45;
		MySharedObject var2 = MySharedObject.sharedInstance;
		methodTwo();
	}

	public void methodTwo() {
		Integer var1 = new Integer(99);
	}
}
