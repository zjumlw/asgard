package com.will.asgard.thor.model.soundsystem.player;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.will.asgard.thor.model.soundsystem.cd.CDConfig;
import com.will.asgard.thor.model.soundsystem.cd.CompactDisc;
import com.will.asgard.thor.model.soundsystem.player.impl.CDPlayer;

/**
 * 组件扫描默认是不启用的，这里显式的配置，命令spring寻找带有@Component注解的类，并为其创建bean
 * 没有其他配置的话，会默认扫描和配置类相同的包(子包)
 */
@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig {

    @Bean
    public CDPlayer cdPlayer(CompactDisc cd) {
        return new CDPlayer(cd);
    }

}
