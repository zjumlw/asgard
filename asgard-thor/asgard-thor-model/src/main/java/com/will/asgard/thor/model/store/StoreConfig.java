package com.will.asgard.thor.model.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class StoreConfig {

    @Bean
    @Scope(value = "request",
            proxyMode = ScopedProxyMode.INTERFACES)
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
