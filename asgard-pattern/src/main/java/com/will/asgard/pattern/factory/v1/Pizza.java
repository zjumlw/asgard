package com.will.asgard.pattern.factory.v1;

import lombok.Data;
import lombok.Getter;

/**
 * @author willmao
 * @date 2022-12-07 12:27
 **/
@Data
public abstract class Pizza {
    /**
     * 名称
     */
    @Getter
    protected String name;

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String info() {
        return "This is a " + name;
    }
}
