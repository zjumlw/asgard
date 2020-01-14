package com.will.asgard.thor.model.car.bmw;

import com.will.asgard.thor.model.car.Car;
import org.springframework.stereotype.Component;

@Component
public class BMW3Series implements Car {
    @Override
    public void drive() {
        System.out.println("BMW3Series drives.");
    }
}
