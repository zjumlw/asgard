package com.will.asgard.pattern.factory.v3;

/**
 * 蛤蜊比萨同理
 *
 * @author willmao
 * @date 2022-12-08 00:59
 **/
public class ClamPizza extends Pizza {

    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClams();
    }
}
