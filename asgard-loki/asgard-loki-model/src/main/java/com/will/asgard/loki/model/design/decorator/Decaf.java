package com.will.asgard.loki.model.design.decorator;

/**
 * @ClassName Decaf
 * @Description 低咖啡因咖啡
 * @Author maolingwei
 * @Date 2020-04-25 20:17
 * @Version 1.0
 **/
public class Decaf extends Beverage {

	public Decaf() {
		this.description = "Decaf";
	}

	@Override
	public double cost() {
		return 1.05;
	}
}
