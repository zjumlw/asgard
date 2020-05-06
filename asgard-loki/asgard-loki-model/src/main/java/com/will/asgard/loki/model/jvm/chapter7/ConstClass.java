package com.will.asgard.loki.model.jvm.chapter7;

/**
 * @ClassName ConstClass
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-05 18:55
 * @Version 1.0
 **/
public class ConstClass {
	static {
		System.out.println("ConstClass init!");
	}

	public static final String HELLOWORLD = "Hello World!";
}
