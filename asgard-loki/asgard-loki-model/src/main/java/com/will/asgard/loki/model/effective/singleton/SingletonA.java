package com.will.asgard.loki.model.effective.singleton;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName SingletonA
 * @Description 单元素枚举的单例实现
 * @Auther maolingwei
 * @Date 2020-01-21 17:05
 * @Version 1.0
 **/

public enum SingletonA {
	INSTANCE("singletonA");

	@Getter
	@Setter
	private String name;

	SingletonA(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		SingletonA singletonA = SingletonA.INSTANCE;
		System.out.println(singletonA.getName());
	}
}
