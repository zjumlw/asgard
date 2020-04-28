package com.will.asgard.loki.model.proxy;

import java.io.File;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

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

		String bootPath = System.getProperty("sun.boot.class.path");
		File[] bootFiles = getClassPath(bootPath);
		System.out.println("bootFiles length: " + bootFiles.length);
		Stream.of(bootFiles).forEach(file -> System.out.println(file.getAbsolutePath()));

		String extPath = System.getProperty("java.ext.dirs");
		File[] extFiles = getClassPath(extPath);
		System.out.println("extFiles length: " + extFiles.length);
		Stream.of(extFiles).forEach(file -> System.out.println(file.getAbsolutePath()));

		String appPath = System.getProperty("java.class.path");
		File[] appFiles = getClassPath(appPath);
		System.out.println("appFiles length: " + appFiles.length);
		Stream.of(appFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
	}

	private static File[] getClassPath(String cp) {
		File[] path;
		if (cp != null) {
			int count = 0, maxCount = 1;
			int pos = 0, lastPos = 0;
			// Count the number of separators first
			while ((pos = cp.indexOf(File.pathSeparator, lastPos)) != -1) {
				maxCount++;
				lastPos = pos + 1;
			}
			path = new File[maxCount];
			lastPos = pos = 0;
			// Now scan for each path component
			while ((pos = cp.indexOf(File.pathSeparator, lastPos)) != -1) {
				if (pos - lastPos > 0) {
					path[count++] = new File(cp.substring(lastPos, pos));
				} else {
					// empty path component translates to "."
					path[count++] = new File(".");
				}
				lastPos = pos + 1;
			}
			// Make sure we include the last path component
			if (lastPos < cp.length()) {
				path[count++] = new File(cp.substring(lastPos));
			} else {
				path[count++] = new File(".");
			}
			// Trim array to correct size
			if (count != maxCount) {
				File[] tmp = new File[count];
				System.arraycopy(path, 0, tmp, 0, count);
				path = tmp;
			}
		} else {
			path = new File[0];
		}
		// DEBUG
		//for (int i = 0; i < path.length; i++) {
		//  System.out.println("path[" + i + "] = " + '"' + path[i] + '"');
		//}
		return path;
	}
}
