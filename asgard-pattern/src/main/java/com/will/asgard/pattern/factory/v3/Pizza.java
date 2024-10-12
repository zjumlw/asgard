package com.will.asgard.pattern.factory.v3;

import com.will.asgard.pattern.factory.Cheese;
import com.will.asgard.pattern.factory.Clams;
import com.will.asgard.pattern.factory.Dough;
import com.will.asgard.pattern.factory.Pepperoni;
import com.will.asgard.pattern.factory.Sauce;
import com.will.asgard.pattern.factory.Veggies;

import lombok.Data;
import lombok.Setter;

/**
 * @author willmao
 * @date 2022-12-07 12:24
 **/
@Data
public abstract class Pizza {
    /**
     * 名称
     */
    String name;

    /**
     * 面团
     */
    Dough dough;

    /**
     * 酱料
     */
    Sauce sauce;

    Veggies[] veggies;

    Cheese cheese;

    Pepperoni pepperoni;

    Clams clams;

    /**
     * 将 prepare 方法进行抽象，子类需要实现这个方法，收集比萨所需的原料
     */
    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String toString() {
        return "This is a " + name;
    }
}
