package com.will.asgard.loki.model.effective.builder.car;

/**
 * @ClassName CarDirector
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-21 12:29
 * @Version 1.0
 **/
public class CarDirector {
	public Car buildCar(CarBuilder carBuilder) {
		carBuilder.buildBody();
		carBuilder.buildEngine();
		carBuilder.buildPower();
		carBuilder.buildSteering();
		carBuilder.buildSuspension();
		return carBuilder.buildCar();
	}
}
