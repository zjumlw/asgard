package com.will.asgard.loki.model.effective.builder.car;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName CarDirectorTest
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-21 15:57
 * @Version 1.0
 **/
public class CarDirectorTest {

	@Test
	public void testBuilder() {
		CarDirector carDirector = new CarDirector();
		Car audiCar = carDirector.buildCar(new AudiCarBuilder());
		Car bmwCar = carDirector.buildCar(new BmwCarBuilder());
	}

}