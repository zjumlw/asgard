package com.will.asgard.thor.service.dessert;

import com.will.asgard.thor.model.dessert.Cake;
import com.will.asgard.thor.model.dessert.DessertConfig;
import com.will.asgard.thor.model.dessert.DessertPlate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DessertMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DessertConfig.class);
        DessertPlate dessertPlate = (DessertPlate) context.getBean("dessertPlate");
        dessertPlate.getDessert().eat();

        Cake cake = (Cake) context.getBean("cake");
        cake.eat();
    }
}
