package com.will.asgard.pattern.factory;

import java.util.ArrayList;
import java.util.List;

import com.will.asgard.pattern.factory.v2.Cheese;
import com.will.asgard.pattern.factory.v2.Clams;
import com.will.asgard.pattern.factory.v2.Pepperoni;
import com.will.asgard.pattern.factory.v2.Veggies;

import lombok.Getter;

/**
 * @author willmao
 * @date 2022-11-22 12:54
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
    
    protected Veggies[] veggies;
    
    protected Cheese cheese;
    
    protected Pepperoni pepperoni;
    
    protected Clams clams;

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
