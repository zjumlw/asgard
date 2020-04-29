package com.will.asgard.loki.model.proxy;

import java.lang.reflect.Modifier;

/**
 * @ClassName ModifiersTest
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-29 14:20
 * @Version 1.0
 **/
public class ModifiersTest {

	public static void main(String[] args) {
		ModifiersTest modifiersTest = new ModifiersTest();
		Class<?> c = modifiersTest.getClass();
		int modifiers = c.getModifiers();
		System.out.println(modifiers);

		String res = Modifier.toString(modifiers);
		System.out.println(res);
	}
}
