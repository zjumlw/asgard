package com.will.asgard.pattern.observer.v2;

import java.util.Observable;
import java.util.Observer;

import com.will.asgard.pattern.observer.DisplayElement;

/**
 * @author willmao
 * @date 2022-11-16 00:43
 **/
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;

    private float lastPressure;

    private Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("lastPressure is " + lastPressure + ", currentPressure is " + currentPressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }
}
