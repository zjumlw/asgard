package com.will.asgard.pattern.factory.v2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * @author willmao
 * @date 2022-12-07 12:24
 **/
public abstract class Pizza {
    /**
     * 名称
     */
    @Getter
    protected String name;

    /**
     * 面团
     */
    protected String dough;

    /**
     * 酱料
     */
    protected String sauce;

    /**
     * 佐料
     */
    protected List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + toppings.get(i));
        }
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
