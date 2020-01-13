package com.will.asgard.thor.model.dessert;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DessertPlate {

    @Getter
    private Dessert dessert;

    @Autowired
    @Qualifier("cake")
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
