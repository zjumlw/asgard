package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName Beverage
 * @Description 饮料
 * @Author maolingwei
 * @Date 2020-04-25 20:08
 * @Version 1.0
 **/
public abstract class Beverage {
	protected String description = "Unknow Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
