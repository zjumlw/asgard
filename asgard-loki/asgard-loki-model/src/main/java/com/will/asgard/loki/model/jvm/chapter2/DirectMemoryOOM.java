package com.will.asgard.loki.model.jvm.chapter2;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @ClassName DirectMemoryOOM
 * @Description 使用unsafe分配本机器内存
 * VM args:
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @Author maolingwei
 * @Date 2020-05-01 15:12
 * @Version 1.0
 **/
public class DirectMemoryOOM {

	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) throws IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		for (; ; ) {
			unsafe.allocateMemory(_1MB);
		}
	}
}
