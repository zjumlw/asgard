package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName Whip
 * @Description 奶泡
 * @Author maolingwei
 * @Date 2020-04-25 20:26
 * @Version 1.0
 **/
public class Whip extends CondimentDecorator {

	public Whip(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.10;
	}
}
