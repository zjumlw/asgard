package com.will.asgard.loki.model.jvm.chapter7;

/**
 * @ClassName SuperClass
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-05 18:30
 * @Version 1.0
 **/
public class SuperClass {
	static {
		System.out.println("SuperClass init!");
	}

	public static int value = 123;
}
