package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName Soy
 * @Description 豆浆
 * @Author maolingwei
 * @Date 2020-04-25 20:24
 * @Version 1.0
 **/
public class Soy extends CondimentDecorator {

	public Soy(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.15;
	}
}
