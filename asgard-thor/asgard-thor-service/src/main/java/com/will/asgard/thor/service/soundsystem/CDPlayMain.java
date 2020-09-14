package com.will.asgard.thor.service.soundsystem;

import com.will.asgard.thor.model.soundsystem.player.impl.CDPlayer;
import com.will.asgard.thor.model.soundsystem.SoundSystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CDPlayMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemConfig.class);
        CDPlayer cdPlayer = (CDPlayer) context.getBean("cdPlayer");
        cdPlayer.play();
    }
}
