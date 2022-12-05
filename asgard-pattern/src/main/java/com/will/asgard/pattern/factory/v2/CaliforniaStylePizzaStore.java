package com.will.asgard.pattern.factory.v2;

import com.will.asgard.pattern.factory.Pizza;
import com.will.asgard.pattern.factory.PizzaType;

/**
 * 加州风味比萨店。
 *
 * @author willmao
 * @date 2022-11-24 02:16
 **/
public class CaliforniaStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals(PizzaType.CHEESE.getName())) {
            pizza = new CaliforniaStyleCheesePizza();
        } else if (type.equals(PizzaType.PEPPERONI.getName())) {
            pizza = new CaliforniaStylePepperoniPizza();
        } else if (type.equals(PizzaType.CLAM.getName())) {
            pizza = new CaliforniaStyleClamPizza();
        } else if (type.equals(PizzaType.VEGGIE.getName())) {
            pizza = new CaliforniaStyleVeggiePizza();
        }
        return pizza;
    }
}
