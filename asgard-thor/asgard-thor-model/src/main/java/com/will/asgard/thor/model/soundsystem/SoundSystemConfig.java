package com.will.asgard.thor.model.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.will.asgard.thor.model.soundsystem.cd")
//@Import({CDConfig.class, CDPlayerConfig.class})
public class SoundSystemConfig {
}
