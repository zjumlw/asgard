package com.will.asgard.pattern.observer.v2;

import java.util.Observable;

import lombok.Getter;

/**
 * 气象数据，继承 Java 内置的 Observable 类来实现。
 *
 * @author willmao
 * @date 2022-11-16 00:27
 **/
public class WeatherData extends Observable {
    /**
     * 温度
     */
    @Getter
    private float temperature;

    /**
     * 湿度
     */
    @Getter
    private float humidity;

    /**
     * 气压
     */
    @Getter
    private float pressure;

    /**
     * 气象测量更新，此方法就会被调用
     */
    public void measurementsChanged() {
        setChanged();
        // 没有传送数据对象，说明采用拉的做法
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
