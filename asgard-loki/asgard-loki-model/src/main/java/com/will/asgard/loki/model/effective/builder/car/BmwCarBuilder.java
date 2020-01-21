package com.will.asgard.loki.model.effective.builder.car;

/**
 * @ClassName BmwCarBuilder
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-21 12:31
 * @Version 1.0
 **/
public class BmwCarBuilder implements CarBuilder {
	@Override
	public void buildEngine() {
		System.out.println("build bmw engine");
	}

	@Override
	public void buildPower() {
		System.out.println("build bmw power");
	}

	@Override
	public void buildBody() {
		System.out.println("build bmw body");
	}

	@Override
	public void buildSteering() {
		System.out.println("build bmw steering");
	}

	@Override
	public void buildSuspension() {
		System.out.println("build bmw suspension");
	}

	@Override
	public Car buildCar() {
		return null;
	}
}
