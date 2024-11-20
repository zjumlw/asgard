package com.will.asgard.pattern.observer.v1;

/**
 * 所有潜在的观察者必须实现观察者接口。
 *
 * @author willmao
 * @date 2022-11-15 00:36
 **/
public interface Observer {

    /**
     * 当主题状态改变时，应该调用更新方法。
     *
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temp, float humidity, float pressure);
}
