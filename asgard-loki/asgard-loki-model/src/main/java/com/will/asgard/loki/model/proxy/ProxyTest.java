package com.will.asgard.loki.model.proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName Proxytest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-28 00:45
 * @Version 1.0
 **/
public class ProxyTest {
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		MyIntf myIntf = (MyIntf) Proxy.newProxyInstance(MyIntf.class.getClassLoader(),
				new Class[]{MyIntf.class}, new MyInvocationHandler());
		myIntf.helloWorld();
		System.out.println("$Proxy0.class全名: " + Proxy.getProxyClass(MyIntf.class.getClassLoader(), MyIntf.class));

		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("java.class.path"));
	}
}
