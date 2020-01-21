package com.will.asgard.loki.model.effective.singleton;

import org.junit.Assert;
import org.junit.Test;


/**
 * @ClassName SingletonATest
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-21 17:23
 * @Version 1.0
 **/
public class SingletonATest {
	@Test
	public void test() {
		SingletonA singletonA = SingletonA.INSTANCE;
		singletonA.setName("tom");
		Assert.assertEquals("tom", singletonA.getName());

		SingletonA anotherSingletonA = SingletonA.INSTANCE;
		Assert.assertEquals("tom", anotherSingletonA.getName());
	}
}