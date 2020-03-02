package com.will.asgard.loki.model.effective.chapter6;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlanetTest {

	@Test
	public void testEarth() {
		double earthGravity = Planet.EARTH.surfaceGravity();
		System.out.println(earthGravity);

		double earthWeight = 65.5;
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for (Planet planet : Planet.values()) {
			System.out.println("Weight on " + planet + " is " + planet.surfaceWeight(mass));
		}
	}
}