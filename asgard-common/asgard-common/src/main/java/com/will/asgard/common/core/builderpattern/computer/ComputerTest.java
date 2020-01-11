package com.will.asgard.common.core.builderpattern.computer;

/**
 * Created by WillMao on 19-5-8
 */
public class ComputerTest {

	public static void main(String[] args) {
		ComputerDirector computerDirector = new ComputerDirector();

		Computer t410 = computerDirector.constructT410();
		Computer x201 = computerDirector.constructX201();

		System.out.println(t410);
		System.out.println("----------");
		System.out.println(x201);
	}
}
