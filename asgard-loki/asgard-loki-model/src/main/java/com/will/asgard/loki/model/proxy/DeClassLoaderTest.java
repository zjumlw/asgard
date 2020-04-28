package com.will.asgard.loki.model.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName DeClassLoaderTest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-29 00:32
 * @Version 1.0
 **/
public class DeClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		String filePath = "/home/will/tmp/Test.class";
		FileUtils.encryptFile(filePath);

		DeClassLoader dcl = new DeClassLoader("/home/will/tmp");
		Class c = dcl.findClass("com.will.asgard.loki.model.proxy.Test");
		if (c != null) {
			try {
				Object o = c.newInstance();
				Method m = c.getDeclaredMethod("say", null);
				m.invoke(o, null);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
