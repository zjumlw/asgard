package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName Espresso
 * @Description 浓咖啡
 * @Author maolingwei
 * @Date 2020-04-25 20:12
 * @Version 1.0
 **/
public class Espresso extends Beverage {

	public Espresso() {
		this.description = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}
}
