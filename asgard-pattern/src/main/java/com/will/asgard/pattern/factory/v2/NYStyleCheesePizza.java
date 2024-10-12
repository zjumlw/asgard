package com.will.asgard.pattern.factory.v2;

/**
 * @author willmao
 * @date 2022-11-24 01:59
 **/
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
