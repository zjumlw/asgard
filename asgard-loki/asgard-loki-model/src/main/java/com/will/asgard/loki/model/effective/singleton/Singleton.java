package com.will.asgard.loki.model.effective.singleton;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Singleton
 * @Description 静态内部类实现单例
 * @Auther maolingwei
 * @Date 2020-01-21 17:03
 * @Version 1.0
 **/
public class Singleton {
	public static Singleton getInstance() {
		return Holder.INSTANCE;
	}

	private static class Holder {
		private static final Singleton INSTANCE = new Singleton();
	}

	@Getter
	@Setter
	private String name;

	private Singleton() {
		this.name = "singleton";
	}
}
