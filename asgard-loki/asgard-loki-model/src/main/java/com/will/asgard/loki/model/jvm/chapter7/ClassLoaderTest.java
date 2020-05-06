package com.will.asgard.loki.model.jvm.chapter7;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-07 01:46
 * @Version 1.0
 **/
public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}

					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};

		Object obj = myLoader.loadClass("com.will.asgard.loki.model.jvm.chapter7.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof ClassLoaderTest);
	}
}
