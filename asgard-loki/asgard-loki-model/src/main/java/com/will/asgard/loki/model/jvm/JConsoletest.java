package com.will.asgard.loki.model.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JConsoletest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-30 02:01
 * @Version 1.0
 **/
public class JConsoletest {

	public JConsoletest() {
		byte[] b = new byte[128 * 1024];
	}

	public static void main(String[] args) throws Exception {
		Thread.sleep(5000);
		System.out.println("start");

		int n = 1000;
		List<JConsoletest> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Thread.sleep(100);
			System.out.println("i: " + i);
			list.add(new JConsoletest());
		}

		System.out.println("stop");
	}
}
