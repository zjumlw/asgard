package com.will.asgard.thor.model.concert;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by WillMao on 19-7-11
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ConcertConfig {

    //	@Bean
    public Audience audience() {
        return new Audience();
    }
}


