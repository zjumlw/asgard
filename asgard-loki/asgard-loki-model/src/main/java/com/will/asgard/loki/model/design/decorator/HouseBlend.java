package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName HouseBlend
 * @Description 综合咖啡
 * @Author maolingwei
 * @Date 2020-04-25 20:15
 * @Version 1.0
 **/
public class HouseBlend extends Beverage {

	public HouseBlend() {
		this.description = "HouseBlend";
	}

	@Override
	public double cost() {
		return 0.89;
	}
}
