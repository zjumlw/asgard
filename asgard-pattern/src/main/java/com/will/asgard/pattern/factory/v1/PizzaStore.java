package com.will.asgard.pattern.factory.v1;

import com.will.asgard.pattern.factory.Pizza;

/**
 * 比萨店对象。
 * 需要一个比萨工厂来创建比萨。
 *
 * @author willmao
 * @date 2022-11-24 01:18
 **/
public class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);
        pizza.prepare();;
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
