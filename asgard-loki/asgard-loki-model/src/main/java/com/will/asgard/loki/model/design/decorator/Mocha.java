package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName Mocha
 * @Description 摩卡
 * @Author maolingwei
 * @Date 2020-04-25 20:21
 * @Version 1.0
 **/
public class Mocha extends CondimentDecorator {

	public Mocha(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.20;
	}
}
