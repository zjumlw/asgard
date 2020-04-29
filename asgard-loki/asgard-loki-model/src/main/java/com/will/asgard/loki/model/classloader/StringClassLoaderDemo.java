package com.will.asgard.loki.model.classloader;

/**
 * @ClassName StringClassLoaderDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-29 23:25
 * @Version 1.0
 **/
public class StringClassLoaderDemo {

	public static void main(String[] args) {
		System.out.println(String.class.getClassLoader());
		System.out.println(int.class.getClassLoader());
		System.out.println(StringClassLoaderDemo.class.getClassLoader());
		System.out.println(StringClassLoaderDemo.class.getClassLoader().getParent());
	}
}
