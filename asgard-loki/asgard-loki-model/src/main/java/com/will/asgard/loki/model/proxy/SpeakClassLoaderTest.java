package com.will.asgard.loki.model.proxy;

import java.lang.reflect.Method;

/**
 * @ClassName SpeakClassLoaderTest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-29 00:49
 * @Version 1.0
 **/
public class SpeakClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		DiskClassLoader dcl = new DiskClassLoader("/home/will/tmp/test");
		Class c = dcl.findClass("com.will.asgard.loki.model.proxy.SpeakTest");
		System.out.println(c.getClassLoader());
		if (c != null) {
			try {
				Object o = c.newInstance();
				Method m = c.getDeclaredMethod("speak", null);
				m.invoke(o, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		DiskClassLoader dcl1 = new DiskClassLoader("/home/will/tmp");
		System.out.println("Thread " + Thread.currentThread().getName()
				+ ", classloader: " + Thread.currentThread().getContextClassLoader().toString());

		new Thread(new Runnable() {
			@Override
			public void run() {
				Thread.currentThread().setContextClassLoader(dcl1);
				System.out.println("Thread " + Thread.currentThread().getName()
						+ ", classloader: " + Thread.currentThread().getContextClassLoader().toString());

				ClassLoader cl = Thread.currentThread().getContextClassLoader();
				try {
					Class c1 = cl.loadClass("com.will.asgard.loki.model.proxy.SpeakTest");
					System.out.println(c1.getClassLoader());

					if (c1 != null) {
						Object o = c1.newInstance();
						Method m = c1.getDeclaredMethod("speak", null);
						m.invoke(o, null);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
