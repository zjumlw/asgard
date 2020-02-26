package com.will.asgard.loki.model.generic.wildcards;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by WillMao on 19-1-18
 */
@Getter
public class Food {
	private String name;
	private double weight;

	public Food() {
	}

	public Food(String name) {
		this.name = name;
	}

	public Food(double weight) {
		this.weight = weight;
	}

	public Food(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
