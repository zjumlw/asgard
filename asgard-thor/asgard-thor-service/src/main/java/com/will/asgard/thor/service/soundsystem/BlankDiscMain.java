package com.will.asgard.thor.service.soundsystem;

import com.will.asgard.thor.model.soundsystem.cd.BlankDisc;
import com.will.asgard.thor.model.soundsystem.cd.ExpressiveConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlankDiscMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ExpressiveConfig.class);
        BlankDisc disc = (BlankDisc) context.getBean("blankDisc");
        disc.play();
    }
}
