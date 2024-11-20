package com.will.asgard.pattern.observer.v2;

import java.util.Observable;
import java.util.Observer;

import com.will.asgard.pattern.observer.DisplayElement;

/**
 * @author willmao
 * @date 2022-11-16 00:27
 **/
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    /**
     * 被观察者，感觉可以使用实际的类型，也可以使用父类（更加灵活）
     */
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
