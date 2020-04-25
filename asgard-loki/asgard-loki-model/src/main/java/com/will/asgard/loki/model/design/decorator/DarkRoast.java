package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName DarkRoast
 * @Description 深焙咖啡
 * @Author maolingwei
 * @Date 2020-04-25 20:15
 * @Version 1.0
 **/
public class DarkRoast extends Beverage {

	public DarkRoast() {
		this.description = "DarkRoast";
	}

	@Override
	public double cost() {
		return 0.99;
	}
}
