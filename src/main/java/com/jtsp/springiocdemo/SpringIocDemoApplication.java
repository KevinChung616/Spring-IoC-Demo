package com.jtsp.springiocdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIocDemoApplication {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("======== APPLICATION START  ========");
        ApplicationContext applicationContext = SpringApplication.run(SpringIocDemoApplication.class, args);


        // ======== BEAN SCOPE SECTION  ========
        System.out.println("======== BEAN SCOPE SECTION  ========");
        System.out.println("======== PROTOTYPE ========");
        CoffeeBean coffeeBean1 = (CoffeeBean) applicationContext.getBean("coffeeBean");
        CoffeeBean coffeeBean2 = (CoffeeBean) applicationContext.getBean("coffeeBean");
        CoffeeBean coffeeBean3 = (CoffeeBean) applicationContext.getBean("coffeeBean");


        System.out.println("coffeeBean 1 memory address: " + coffeeBean1.hashCode());
        System.out.println("coffeeBean 2 memory address: " + coffeeBean2.hashCode());
        System.out.println("coffeeBean 3 memory address: " + coffeeBean3.hashCode());
        Thread.sleep(1000);

        // Bean Scope: Singleton
        System.out.println("======== SINGLETON ========");
        CoffeeMaker coffeeMaker1 = (CoffeeMaker) applicationContext.getBean("coffeeMaker");
        CoffeeMaker coffeeMaker2 = (CoffeeMaker) applicationContext.getBean("coffeeMaker");

        System.out.println("coffeeMaker 1 memory address: " + coffeeMaker1.hashCode());
        System.out.println("coffeeMaker 2 memory address: " + coffeeMaker2.hashCode());
        System.out.println(coffeeMaker1 == coffeeMaker2);
        Thread.sleep(1000);

        System.out.println("======== BEAN SCOPE IN COFFEE MAKER ========");
        // Make 1st Cup of Coffee
        System.out.println(coffeeMaker1.makeCoffee());

        // Make 2nd Cup of Coffee
        System.out.println(coffeeMaker1.makeCoffee());

        // Make 3rd Cup of Coffee
        System.out.println(coffeeMaker1.makeCoffee());

        Thread.sleep(1000);

    }

}
