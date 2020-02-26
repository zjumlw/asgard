package com.will.asgard.loki.model.generic.wildcards;

/**
 * Created by WillMao on 19-1-18
 */
public class Fruit extends Food {
	public Fruit() {
		this("fruit");
	}

	public Fruit(String name) {
		this(name, 1);
	}

	public Fruit(double weight) {
		this("fruit", weight);
	}

	public Fruit(String name, double weight) {
		super(name, weight);
	}
}
