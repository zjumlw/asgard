package com.will.asgard.loki.model.design.observer.impl;

import java.util.Observable;

import lombok.Getter;

/**
 * @ClassName WeatherData
 * @Description rt
 * @Author maolingwei
 * @Date 2020-04-25 01:25
 * @Version 1.0
 **/
@Getter
public class WeatherDataV2 extends Observable {
	private double temperature;
	private double humidity;
	private double pressure;

	public void measurementChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(double temperature, double humidity, double pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}


}
