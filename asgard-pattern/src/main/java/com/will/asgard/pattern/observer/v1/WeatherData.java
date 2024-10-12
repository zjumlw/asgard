package com.will.asgard.pattern.observer.v1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.Getter;

/**
 * 气象数据就是一个主题，需要实现主题接口。
 *
 * @author willmao
 * @date 2022-11-15 00:28
 **/
public class WeatherData implements Subject {

    /**
     * 所有观察者
     */
    private List<Observer> observers;

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

    public WeatherData() {
        this.observers = new CopyOnWriteArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(0);
    }

    @Override
    public void removeObservers() {
        observers.clear();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 气象测量更新，此方法就会被调用
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
