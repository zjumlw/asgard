package com.will.asgard.loki.model.interview.alibaba;

/**
 * @ClassName SwitchExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-26 23:00
 * @Version 1.0
 **/
public class SwitchExample {
	public static void main(String[] args) {
		byte a = 127;
		long b = 128;
		short c = (short) 19;
		String d = "hello";
		switch (d) {
			case "hello":
				System.out.println("get");
				break;
			default:
				System.out.println("no");
				break;
		}
	}
}
