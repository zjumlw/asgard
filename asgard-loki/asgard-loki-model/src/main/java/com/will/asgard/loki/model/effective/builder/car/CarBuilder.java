package com.will.asgard.loki.model.effective.builder.car;

/**
 * @ClassName CarBuilder
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-21 12:22
 * @Version 1.0
 **/
public interface CarBuilder {

	void buildEngine();

	void buildPower();

	void buildBody();

	void buildSteering();

	void buildSuspension();

	Car buildCar();
}
