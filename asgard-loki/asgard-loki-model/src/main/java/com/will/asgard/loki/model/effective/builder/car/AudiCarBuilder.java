package com.will.asgard.loki.model.effective.builder.car;

/**
 * @ClassName AudiCarBuilder
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-21 12:31
 * @Version 1.0
 **/
public class AudiCarBuilder implements CarBuilder {

	@Override
	public void buildEngine() {
		System.out.println("build audi engine");
	}

	@Override
	public void buildPower() {
		System.out.println("build audi power");
	}

	@Override
	public void buildBody() {
		System.out.println("build audi body");
	}

	@Override
	public void buildSteering() {
		System.out.println("build audi steering");
	}

	@Override
	public void buildSuspension() {
		System.out.println("build audi suspension");
	}

	@Override
	public Car buildCar() {
		return null;
	}
}
