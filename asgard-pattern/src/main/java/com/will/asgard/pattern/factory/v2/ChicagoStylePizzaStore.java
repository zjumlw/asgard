package com.will.asgard.pattern.factory.v2;

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
        if (type.equals(PizzaType.CHEESE.getType())) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals(PizzaType.PEPPERONI.getType())) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals(PizzaType.CLAM.getType())) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals(PizzaType.VEGGIE.getType())) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
