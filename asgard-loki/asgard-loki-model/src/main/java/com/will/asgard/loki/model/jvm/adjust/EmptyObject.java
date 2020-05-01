package com.will.asgard.loki.model.jvm.adjust;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName EmptyObject
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-30 20:49
 * @Version 1.0
 **/
public class EmptyObject {
	int a = 0;
	int b = 0;
	int[] c = {1, 2, 3};

	public static void main(String[] args) {
		EmptyObject emptyObject = new EmptyObject();
		System.out.println(ClassLayout.parseInstance(emptyObject).toPrintable());
	}
}
