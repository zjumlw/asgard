package com.will.asgard.thor.model.soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.will.asgard.thor.model.soundsystem.cd.CDConfig;
import com.will.asgard.thor.model.soundsystem.player.CDPlayerConfig;

@Configuration
//@ComponentScan(basePackages = "com.will.asgard.thor.model.soundsystem")
@Import({CDConfig.class, CDPlayerConfig.class})
public class SoundSystemConfig {
}
