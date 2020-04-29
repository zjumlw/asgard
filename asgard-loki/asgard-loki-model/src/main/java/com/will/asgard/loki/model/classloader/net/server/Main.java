package com.will.asgard.loki.model.classloader.net.server;

import java.lang.reflect.Method;

/**
 * @ClassName Main
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-30 00:32
 * @Version 1.0
 **/
public class Main {

	private static final String CLASS_NAME = "com.will.asgard.loki.model.proxy.Test";
	public static void main(String[] args) throws Exception {
		NetClassLoader netClassLoader = new NetClassLoader();
		Class<?> clazz = netClassLoader.loadData(CLASS_NAME);
		Object o = clazz.newInstance();
		Method method = clazz.getMethod("say", null);
		method.invoke(o, null);
	}
}
