package com.will.asgard.loki.model.proxy;

import java.lang.reflect.Method;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-28 22:44
 * @Version 1.0
 **/
public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		DiskClassLoader dcl = new DiskClassLoader("/home/will/tmp");

		Class c = dcl.findClass("com.will.asgard.loki.model.proxy.Test");
		try {
			if (c != null) {
				Object o = c.newInstance();
				Method m = c.getDeclaredMethod("say", null);
				m.invoke(o, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
