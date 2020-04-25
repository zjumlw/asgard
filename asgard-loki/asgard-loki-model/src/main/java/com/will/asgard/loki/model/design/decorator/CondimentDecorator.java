package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName CondimentDecorator
 * @Description rt
 * @Author maolingwei
 * @Date 2020-04-25 20:09
 * @Version 1.0
 **/
public abstract class CondimentDecorator extends Beverage {

	protected Beverage beverage;

	public CondimentDecorator(Beverage beverage) {
		this.beverage = beverage;
	}

	public abstract String getDescription();
}
