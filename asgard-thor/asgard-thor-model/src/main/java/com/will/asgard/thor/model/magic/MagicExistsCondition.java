package com.will.asgard.thor.model.magic;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        boolean flag = env.containsProperty("magic");
        if (flag) {
            System.out.println("magic: " + env.getProperty("magic"));
        }
        return flag;
    }
}
