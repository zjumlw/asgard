package com.will.asgard.thor.model.soundsystem.player;

import com.will.asgard.thor.model.soundsystem.cd.CDConfig;
import com.will.asgard.thor.model.soundsystem.cd.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig {

    @Bean
    public CDPlayer cdPlayer(CompactDisc cd) {
        return new CDPlayer(cd);
    }

}
