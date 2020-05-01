package com.will.asgard.loki.model.jvm.chapter2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @ClassName JavaMethodAreaOOM
 * @Description
 *
 * VM args:
 * -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=9M -XX:+HeapDumpOnOutOfMemoryError
 *
 * -XX:+HeapDumpOnOutOfMemoryError参数表示当JVM发生OOM时，自动生成DUMP文件
 * -XX:HeapDumpPath=${目录}参数表示生成DUMP文件的路径，也可以指定文件名称
 *
 * Result:
 * java.lang.OutOfMemoryError: Metaspace
 * Dumping heap to java_pid1788.hprof ...
 * Heap dump file created [3484403 bytes in 0.032 secs]
 * Exception in thread "main"
 * Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
 *
 * @Author maolingwei
 * @Date 2020-05-01 15:01
 * @Version 1.0
 **/
public class JavaMethodAreaOOM {
	private static class OOMObject {
		public OOMObject() {
		}
	}

	public static void main(String[] args) {
		for (; ; ) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy)
					-> methodProxy.invokeSuper(objects, args));
			enhancer.create();
		}
	}
}
