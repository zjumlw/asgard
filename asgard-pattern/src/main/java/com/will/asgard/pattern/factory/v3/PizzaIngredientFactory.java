package com.will.asgard.pattern.factory.v3;

import com.will.asgard.pattern.factory.Cheese;
import com.will.asgard.pattern.factory.Clams;
import com.will.asgard.pattern.factory.Dough;
import com.will.asgard.pattern.factory.Pepperoni;
import com.will.asgard.pattern.factory.Sauce;
import com.will.asgard.pattern.factory.Veggies;

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
