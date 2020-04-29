package com.will.asgard.loki.model.classloader;

import java.io.File;
import java.lang.reflect.Method;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-28 22:44
 * @Version 1.0
 **/
public class DiskClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		DiskClassLoader dcl = new DiskClassLoader("/home/will/tmp");

		Class<?> c = dcl.findClass("com.will.asgard.loki.model.proxy.Test");
		try {
			if (c != null) {
				Object o = c.newInstance();
				Method m = c.getDeclaredMethod("say", null);
				m.invoke(o, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(DiskClassLoaderTest.class.getName());
		System.out.println(Class.forName("com.will.asgard.loki.model.classloader.DiskClassLoaderTest"));

		System.out.println(int.class.getName());
		System.out.println(int[].class);
		System.out.println(double[].class);
		System.out.println(String[].class);

		System.out.println(File.separator);
	}
}
