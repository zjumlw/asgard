package com.will.asgard.pattern.factory.v3;

/**
 * 芝士比萨的做法是一样的，面团、酱料和芝士
 *
 * @author willmao
 * @date 2022-12-08 00:55
 **/
public class CheesePizza extends Pizza {

    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
