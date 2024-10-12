package com.will.asgard.pattern.factory.v3;

import com.will.asgard.pattern.factory.Cheese;
import com.will.asgard.pattern.factory.Clams;
import com.will.asgard.pattern.factory.Dough;
import com.will.asgard.pattern.factory.v2.FreshClams;
import com.will.asgard.pattern.factory.v2.Garlic;
import com.will.asgard.pattern.factory.v2.MarinaraSauce;
import com.will.asgard.pattern.factory.v2.Mushroom;
import com.will.asgard.pattern.factory.v2.Onion;
import com.will.asgard.pattern.factory.Pepperoni;
import com.will.asgard.pattern.factory.v2.RedPepper;
import com.will.asgard.pattern.factory.v2.ReggianoCheese;
import com.will.asgard.pattern.factory.Sauce;
import com.will.asgard.pattern.factory.v2.SlicedPepperoni;
import com.will.asgard.pattern.factory.v2.ThinCrustDough;
import com.will.asgard.pattern.factory.Veggies;

/**
 * @author willmao
 * @date 2022-12-06 00:09
 **/
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
