package com.will.asgard.loki.model.interview.jdk;

import org.junit.Test;

public class InterfaceAImplTest {

	@Test
	public void test() {
		InterfaceAImpl impl = new InterfaceAImpl();
		impl.sayDefault();

		InterfaceA.sayName();

		InterfaceB interfaceBImpl = new InterfaceB() {
			@Override
			public void sayDefault() {
				System.out.println("Default B");
			}
		};

		interfaceBImpl.sayDefault();
	}
}