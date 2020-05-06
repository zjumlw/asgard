package com.will.asgard.loki.model.jvm.chapter4;

import java.util.Scanner;

/**
 * @ClassName JstatDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-01 23:32
 * @Version 1.0
 **/
public class JStatDemo {
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		while (true) {
			if (input > 0) {
				System.out.println(input);
				byte[] a = new byte[input * _1MB];
				input = scanner.nextInt();
			} else {
				break;
			}
		}
	}
}
