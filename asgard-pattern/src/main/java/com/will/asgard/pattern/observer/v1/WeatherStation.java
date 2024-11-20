package com.will.asgard.pattern.observer.v1;

/**
 * @author willmao
 * @date 2022-11-15 01:07
 **/
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        HealthIndexDisplay healthIndexDisplay = new HealthIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4F);
        weatherData.setMeasurements(82, 70, 29.2F);
        weatherData.setMeasurements(78, 90, 29.1F);
    }
}
