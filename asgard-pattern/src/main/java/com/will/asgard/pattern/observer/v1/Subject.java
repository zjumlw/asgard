package com.will.asgard.pattern.observer.v1;

/**
 * 主题接口，对象使用此接口注册为观察者，或者把自己从观察者中删除。
 *
 * @author willmao
 * @date 2022-11-15 00:35
 **/
public interface Subject {

    /**
     * 注册观察者。
     *
     * @param o 待注册的观察者
     */
    void registerObserver(Observer o);

    /**
     * 删除观察者。
     *
     * @param o 待删除的观察者
     */
    void removeObserver(Observer o);

    /**
     * 通知所有观察者
     */
    void notifyObserver();
}
