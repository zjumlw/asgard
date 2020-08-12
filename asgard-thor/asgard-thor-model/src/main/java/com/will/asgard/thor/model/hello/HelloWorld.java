package com.will.asgard.thor.model.hello;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloWorld {
    private static final String DEFAULT_MSG = "default";

    private String message;

    public HelloWorld() {
        this(DEFAULT_MSG);
    }

    public HelloWorld(String message) {
        this.message = message;
    }
}
