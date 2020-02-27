package com.will.asgard.loki.model.generic.wildcards;

import java.util.List;

import com.google.common.collect.Lists;
import com.will.asgard.common.util.GsonUtil;

/**
 * @ClassName AppleMain
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-27 01:41
 * @Version 1.0
 **/
public class AppleMain {
	public static void main(String[] args) {
		List<Apple> apples = Lists.newArrayList();
		apples.add(new Apple());

		List<? super Fruit> fruits = Lists.newArrayList();
		fruits.add(new Banana(1.7));
		Object val = fruits.get(0);

		List<Fruit> fruits1 = Lists.newArrayList();
		fruits1.add(new Apple());
		fruits1.add(new Banana());
	}
}
