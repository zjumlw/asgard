package com.will.asgard.pattern.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 比萨类型。
 *
 * @author willmao
 * @date 2022-11-24 02:05
 **/
@AllArgsConstructor
public enum PizzaType {
    CHEESE("cheese"),
    PEPPERONI("pepperoni"),
    CLAM("clam"),
    VEGGIE("veggie"),
    ;

    @Getter
    private String type;
}
