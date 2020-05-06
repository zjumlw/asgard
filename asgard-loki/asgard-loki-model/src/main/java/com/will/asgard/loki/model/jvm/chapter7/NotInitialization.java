package com.will.asgard.loki.model.jvm.chapter7;

/**
 * @ClassName NotInitialization
 * @Description -XX:+TraceClassLoading
 * @Author maolingwei
 * @Date 2020-05-05 18:32
 * @Version 1.0
 **/
public class NotInitialization {
	public static void main(String[] args) {
		System.out.println(SubClass.value);
	}
}
