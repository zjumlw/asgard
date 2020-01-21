package com.will.asgard.loki.model.effective.singleton;

import org.junit.Assert;
import org.junit.Test;


/**
 * @ClassName SingletonTest
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-21 17:10
 * @Version 1.0
 **/
public class SingletonTest {

	@Test
	public void test() {
		Singleton singleton = Singleton.getInstance();
		Assert.assertEquals("singleton", singleton.getName());
		singleton.setName("tom");
		Assert.assertEquals("tom", singleton.getName());

		Singleton anotherSingleton = Singleton.getInstance();
		Assert.assertEquals("tom", anotherSingleton.getName());
	}
}