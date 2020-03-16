package com.will.asgard.loki.model.interview.jdk;

/**
 * @ClassName InterfaceA
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-03 17:26
 * @Version 1.0
 **/
public interface InterfaceA {
	String NAME = "InterfaceA";
	static void sayName() {
		System.out.println(NAME);
	}

	default void sayDefault() {
		System.out.println("Default");
	}
}
