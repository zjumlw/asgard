package com.will.asgard.loki.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyInvocationHandler
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-28 00:44
 * @Version 1.0
 **/
public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("method: " + method.getName());
		if (method.getName().contains("helloWorld")) {
			System.out.println("hi hello");
		} else if (method.getName().contains("toString")) {
			return "toString method";
		}
		return null;
	}
}
