package com.will.asgard.thor.model.dessert;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cake implements Dessert {
    public Cake() {
        System.out.println("A new cake");
    }

    @Override
    public void eat() {
        System.out.println("Eat cake");
    }
}
