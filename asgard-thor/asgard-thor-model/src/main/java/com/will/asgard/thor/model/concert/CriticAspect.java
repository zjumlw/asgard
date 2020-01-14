package com.will.asgard.thor.model.concert;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CriticAspect {

    private CriticismEngine criticismEngine;

    @Autowired
    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

    @Pointcut("execution(* com.will.asgard.thor.model.concert.Performance.perform(..))")
    public void perform(){};

    @After("perform()")
    public void saySomeThing() {
        criticismEngine.getCriticism();
    }
}
