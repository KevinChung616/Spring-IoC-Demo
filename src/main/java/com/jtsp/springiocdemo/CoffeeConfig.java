package com.jtsp.springiocdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CoffeeConfig {

    @Bean("coffeeBean")
    @Scope("prototype")
    public CoffeeBean produceCoffeeBean() {
        return new CoffeeBean("Ethiopia", "Medium", 15);
    }
}
