package com.will.asgard.pattern.factory.v2;

import com.will.asgard.pattern.factory.Pizza;
import com.will.asgard.pattern.factory.PizzaType;

/**
 * 芝加哥风味比萨店。
 *
 * @author willmao
 * @date 2022-11-24 02:11
 **/
public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals(PizzaType.CHEESE.getName())) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals(PizzaType.PEPPERONI.getName())) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals(PizzaType.CLAM.getName())) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals(PizzaType.VEGGIE.getName())) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
