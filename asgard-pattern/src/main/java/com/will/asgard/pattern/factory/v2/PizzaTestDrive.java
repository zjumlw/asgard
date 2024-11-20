package com.will.asgard.pattern.factory.v2;

import com.will.asgard.pattern.factory.PizzaType;

/**
 * @author willmao
 * @date 2022-11-25 01:32
 **/
public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza(PizzaType.CHEESE.getType());
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza(PizzaType.CHEESE.getType());
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
