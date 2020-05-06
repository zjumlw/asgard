package com.will.asgard.loki.model.jvm.chapter6;

/**
 * @ClassName Main
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-02 01:41
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		char[] chars = new char[100];
		chars[0] = 0x2a;
		chars[1] = 0xb7;
		chars[2] = 0x00;
		chars[3] = 0x01;
		chars[4] = 0xb1;
		chars[5] = 0x75;
		chars[6] = 0x6d;
		chars[7] = 0x62;
		chars[8] = 0x65;
		chars[9] = 0x72;
		chars[10] = 0x54;
		chars[11] = 0x61;
		chars[12] = 0x62;
		chars[13] = 0x6c;
		chars[14] = 0x65;
		for (int i = 0; i <=5; i++) {
			System.out.print(chars[i]);
		}
	}
}
