package com.will.asgard.loki.model.design.observer.impl;

import java.text.MessageFormat;
import java.util.Observable;
import java.util.Observer;

import com.will.asgard.loki.model.design.observer.DisplayElement;

/**
 * @ClassName CurrentConditionsDisplay
 * @Description rt
 * @Author maolingwei
 * @Date 2020-04-25 01:37
 * @Version 1.0
 **/
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private Observable observable;
	private double temperature;
	private double humidity;

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println(MessageFormat
				.format("Current conditions: {0} F degrees and {1}% humidity", temperature, humidity));
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherDataV2) {
			WeatherDataV2 weatherData = (WeatherDataV2) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	public void removeSelf() {
		observable.deleteObserver(this);
	}
}
