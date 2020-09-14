package com.will.asgard.thor.model.soundsystem.cd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.will.asgard.thor.model.hello.ApplicationContextUtil;
import com.will.asgard.thor.model.soundsystem.cd.impl.SgtPeppers;

@Configuration
//@ComponentScan
public class CDConfig {

    @Bean("lonelyHeartsClubBand")
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public ApplicationContextUtil applicationContextUtil() {
        return new ApplicationContextUtil();
    }
}
