package com.will.asgard.pattern.factory.v2;

/**
 * pizza 原料工厂
 *
 * @author willmao
 * @date 2022-12-02 00:32
 **/
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();
}
