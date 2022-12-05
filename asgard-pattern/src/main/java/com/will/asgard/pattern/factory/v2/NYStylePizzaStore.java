package com.will.asgard.pattern.factory.v2;

import com.will.asgard.pattern.factory.Pizza;
import com.will.asgard.pattern.factory.PizzaType;

/**
 * 纽约风味比萨店。
 *
 * @author willmao
 * @date 2022-11-24 01:52
 **/
public class NYStylePizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals(PizzaType.CHEESE.getName())) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals(PizzaType.PEPPERONI.getName())) {
            pizza = new NYStylePepperoniPizza();
        } else if (type.equals(PizzaType.CLAM.getName())) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals(PizzaType.VEGGIE.getName())) {
            pizza = new NYStyleVeggiePizza();
        }
        return pizza;
    }
}
