package com.will.asgard.pattern.observer.v1;

import com.will.asgard.pattern.observer.DisplayElement;

/**
 * @author willmao
 * @date 2022-11-15 01:03
 **/
public class CurrentConditionDisplay implements Observer, DisplayElement {

    /**
     * 主题对象，如果以后要取消注册，持有该对象会比较方便
     */
    private Subject weatherData;

    private float temperature;

    private float humidity;

    /**
     * 构造器需要主题对象，并且完成注册。
     *
     * @param weatherData 天气数据（主题）
     */
    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
