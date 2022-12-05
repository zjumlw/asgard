package com.will.asgard.pattern.factory.v1;

import com.will.asgard.pattern.factory.Pizza;

/**
 * 简单比萨工厂，为所有比萨对象创建对象。
 *
 * @author willmao
 * @date 2022-11-22 23:06
 **/
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
