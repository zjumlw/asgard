package com.will.asgard.loki.model.proxy;

<<<<<<< HEAD
import java.io.File;
import java.lang.reflect.InvocationHandler;
=======
>>>>>>> refactor(classloader): move package
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
		System.out.println(myIntf);

		ClassLoader cl = myIntf.getClass().getClassLoader();
		System.out.println("cl: " + cl);

		Class<?> proxyClass = Proxy.getProxyClass(cl, MyIntf.class);
		System.out.println(proxyClass);
	}
}
