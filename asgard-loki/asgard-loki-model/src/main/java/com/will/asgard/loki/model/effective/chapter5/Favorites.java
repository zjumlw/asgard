package com.will.asgard.loki.model.effective.chapter5;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @ClassName Favorites
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-11 00:11
 * @Version 1.0
 **/
public class Favorites {
	private Map<Class<?>, Object> favorites = Maps.newHashMap();

	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		favorites.put(type, type.cast(instance));
	}

	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}

	public static void main(String[] args) {

	}
}
