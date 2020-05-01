package com.will.asgard.loki.model.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RuntimeConstantPoolOOM
 * @Description -XX:PermSize=10M; support was removed in 8.0
 *     -XX:MaxPermSize=10M; support was removed in 8.0
 *
 *     jdk 1.8
 *      -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=7M -XX:+HeapDumpOnOutOfMemoryError
 * @Author maolingwei
 * @Date 2020-05-01 14:48
 * @Version 1.0
 **/
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		int i = 0;
		for (; ; ) {
			list.add(String.valueOf(i++).intern());
		}
	}

//	public static void main(String[] args) {
//		String str1 = new StringBuilder("计算机").append("软件").toString();
//		System.out.println(str1.intern() == str1);
//
//		String tmp = "java";
//		String str2 = new StringBuilder("ja").append("va").toString();
//		System.out.println(str2.intern() == str2);
//		System.out.println(str2.intern() == tmp);
//	}
}
