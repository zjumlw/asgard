package com.will.asgard.thor.model.concert;

public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("Default perform encore");
    }
}
