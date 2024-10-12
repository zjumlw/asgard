package com.will.asgard.pattern.factory.v3;

import com.will.asgard.pattern.factory.v2.BlackOlives;
import com.will.asgard.pattern.factory.Cheese;
import com.will.asgard.pattern.factory.Clams;
import com.will.asgard.pattern.factory.Dough;
import com.will.asgard.pattern.factory.v2.EggPlant;
import com.will.asgard.pattern.factory.v2.FrozenClams;
import com.will.asgard.pattern.factory.v2.Mozzarella;
import com.will.asgard.pattern.factory.Pepperoni;
import com.will.asgard.pattern.factory.v2.PlumTomatoSauce;
import com.will.asgard.pattern.factory.Sauce;
import com.will.asgard.pattern.factory.v2.SlicedPepperoni;
import com.will.asgard.pattern.factory.v2.Spinach;
import com.will.asgard.pattern.factory.v2.ThickCrustDough;
import com.will.asgard.pattern.factory.Veggies;

/**
 * @author willmao
 * @date 2022-12-06 00:31
 **/
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new BlackOlives(), new Spinach(), new EggPlant()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
