package com.will.asgard.thor.web.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * com.will.asgard.thor.service.spittr 是相当于第三方库，所以要在rootConfig中配置
 */
@Configuration
@ComponentScan(basePackages = {"com.will.asgard.thor.web", "com.will.asgard.thor.service.spittr"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
