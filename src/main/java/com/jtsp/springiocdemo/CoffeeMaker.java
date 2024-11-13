package com.jtsp.springiocdemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMaker {
    private final WaterHeater waterHeater;

    private CoffeeBean coffeeBean;

    // Constructor injection of WaterHeater (IoC and Dependency Injection)
    @Autowired
    public CoffeeMaker(WaterHeater waterHeater) {
        System.out.println("[life Cycle] 1. @Constructor: I am CoffeeMaker and I am created by Spring IOC");
        this.waterHeater = waterHeater;
    }
    // setter injection (IoC and Dependency Injection)
    @Autowired
    public void setCoffeeBean(CoffeeBean coffeeBean) {
        this.coffeeBean = coffeeBean;
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("[life Cycle] 2. @PostConstruct: CoffeeMaker bean initialization logic after constructor.");
    }

    public String makeCoffee() {
        String heatedWater = waterHeater.heatWater();
        return String.format("Make coffee with water=[%s] by water heater id=[%d] and coffee bean=[%s] and bean id=[%d]",
                waterHeater.heatWater(), waterHeater.hashCode(), coffeeBean.toString(), coffeeBean.hashCode());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("[life Cycle] 3. @PreDestroy: Cleaning up before CoffeeMaker bean is destroyed.");
    }

}
