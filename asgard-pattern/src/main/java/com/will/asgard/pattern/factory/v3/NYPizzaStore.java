package com.will.asgard.pattern.factory.v3;


import com.will.asgard.pattern.factory.PizzaType;

/**
 * NY 风味比萨店。
 *
 * @author willmao
 * @date 2022-12-08 01:42
 **/
public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (PizzaType.CHEESE.getType().equals(type)) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (PizzaType.VEGGIE.getType().equals(type)) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        } else if (PizzaType.CLAM.getType().equals(type)) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if (PizzaType.PEPPERONI.getType().equals(type)) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }

        return pizza;
    }
}
