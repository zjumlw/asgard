package com.will.asgard.loki.model.design.observer.impl;

import java.util.ArrayList;
import java.util.List;

import com.will.asgard.loki.model.design.observer.Observer;
import com.will.asgard.loki.model.design.observer.Subject;

/**
 * @ClassName WeatherData
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-25 01:01
 * @Version 1.0
 **/
public class WeatherData implements Subject {
	private final List<Observer> observers = new ArrayList<>();

	@Override
	public void registerObserver(Observer o) {
		synchronized (observers) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		synchronized (observers) {
			observers.remove(o);
		}
	}

	@Override
	public void notifyObserver() {

	}
}
