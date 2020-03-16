package com.will.asgard.loki.model.interview.jdk;

import java.io.Serializable;

import com.will.asgard.common.util.GsonUtil;

import lombok.Data;

/**
 * @ClassName TransientExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-05 00:55
 * @Version 1.0
 **/
public class TransientExample {
	public static void main(String[] args) {
		Apple apple1 = new Apple();
		apple1.setName("apple1");
		apple1.setColor("red");
		apple1.setWeight(1.5);
		System.out.println(GsonUtil.toJson(apple1));
	}

	@Data
	private static class Apple implements Serializable  {
		private static final String CITY = "BJ";
		private String name;
		private transient String color;
		private double weight;
	}
}
