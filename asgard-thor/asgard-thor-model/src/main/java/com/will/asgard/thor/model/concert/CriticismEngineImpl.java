package com.will.asgard.thor.model.concert;

import org.springframework.stereotype.Component;

@Component
public class CriticismEngineImpl implements CriticismEngine {
    @Override
    public void getCriticism() {
        System.out.println("CriticismEngineImpl --> It is bad.");
    }
}
