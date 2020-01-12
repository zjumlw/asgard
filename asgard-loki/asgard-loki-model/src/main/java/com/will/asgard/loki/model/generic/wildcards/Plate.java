package com.will.asgard.loki.model.generic.wildcards;

/**
 * Created by WillMao on 19-1-18
 */
public class Plate<T> {
	private T item;
	public Plate(T t){
		item=t;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}
