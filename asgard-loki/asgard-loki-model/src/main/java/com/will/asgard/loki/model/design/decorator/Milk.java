package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName Milk
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-25 20:27
 * @Version 1.0
 **/
public class Milk extends CondimentDecorator {

	public Milk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.10;
	}
}
