package com.will.asgard.thor.hammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Asgard Thor Hammer 启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.will.asgard.thor.hammer")
public class AsgardThorHammerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsgardThorHammerApplication.class, args);
    }
}
