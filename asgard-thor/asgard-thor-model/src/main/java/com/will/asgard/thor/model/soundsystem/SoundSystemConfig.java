package com.will.asgard.thor.model.soundsystem;

import com.will.asgard.thor.model.soundsystem.cd.CDConfig;
import com.will.asgard.thor.model.soundsystem.player.CDPlayerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CDConfig.class, CDPlayerConfig.class})
public class SoundSystemConfig {
}
