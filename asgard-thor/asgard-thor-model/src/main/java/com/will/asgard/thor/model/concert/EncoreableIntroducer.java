package com.will.asgard.thor.model.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EncoreableIntroducer {
    @DeclareParents(value = "com.will.asgard.thor.model.concert.Performance+",
            defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
