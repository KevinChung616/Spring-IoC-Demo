# Spring IOC Demo
This is a demo of Spring IoC with following key points:

+ IoC Container: `ApplicationContext`
+ Dependency Injection:  `Constructor Injection` + `Setter Injection`
+ Bean Scope: `Singleton`, `Prototype` 
+ Life Cycle

### How to?

First git clone this project to your local.

Then, run the application. You should be able to see logs in the terminal.

### Explanation

#### `SpringIocDemoApplication` Class

This is the main logic we are executing and demonstrating concepts of IoC

Following section is about prototype.
```java
System.out.println("======== PROTOTYPE ========");
        CoffeeBean coffeeBean1 = (CoffeeBean) applicationContext.getBean("coffeeBean");
        CoffeeBean coffeeBean2 = (CoffeeBean) applicationContext.getBean("coffeeBean");
        CoffeeBean coffeeBean3 = (CoffeeBean) applicationContext.getBean("coffeeBean");

        
        System.out.println("coffeeBean 1 memory address: " + coffeeBean1.hashCode());
        System.out.println("coffeeBean 2 memory address: " + coffeeBean2.hashCode());
        System.out.println("coffeeBean 3 memory address: " + coffeeBean3.hashCode());
```

Since `CoffeeBean` is defined as `Prototype` under `CoffeeConfig` class, we are expecting different `coffeeBean`s when we retrieve.
So in above code, we print the hashcode of each bean, which can be viewed as memory address of the object.

We should be able to see different address due to prototype

---

Following section is about Singleton.
```java
 System.out.println("======== SINGLETON ========");
        CoffeeMaker coffeeMaker1 = (CoffeeMaker) applicationContext.getBean("coffeeMaker");
        CoffeeMaker coffeeMaker2 = (CoffeeMaker) applicationContext.getBean("coffeeMaker");

        System.out.println("coffeeMaker 1 memory address: " + coffeeMaker1.hashCode());
        System.out.println("coffeeMaker 2 memory address: " + coffeeMaker2.hashCode());
        System.out.println(coffeeMaker1 == coffeeMaker2);
        
```
Since CoffeeMaker is annotated with `@Component` and it is singleton by default, we should expect same address from above code.

---
Following is adv topic that Singleton `CoffeeMaker` depends on Prototype `CoffeeBean`. 
>Note: This part is Optional.

```java
 System.out.println("======== BEAN SCOPE IN COFFEE MAKER ========");
        // Make 1st Cup of Coffee
        System.out.println(coffeeMaker1.makeCoffee());

        // Make 2nd Cup of Coffee
        System.out.println(coffeeMaker1.makeCoffee());

        // Make 3rd Cup of Coffee
        System.out.println(coffeeMaker1.makeCoffee());
```

We should be able to see same `coffeeBean` address and same `coffeeMaker` id.



### Note
+ `Instantiation`:实例化，指的是调用构造函数进行实例化
+ `Initialization`:初始化，在Bean的声明周期中指的是init-method所指定的方法或者是InitializingBean.afterPropertiesSet()方法

### Adv Topics (Optional) 
`Singleton` Object with `Prototype` Dependency

If a prototype-scoped bean is injected into a singleton-scoped bean, it will not create a new instance each time the singleton bean accesses it. This is because Spring creates and injects dependencies only once at the time the singleton bean is created.

---

`Prototype` Object with `Singleton` Dependency

Since singleton beans are created only once and managed by the Spring container for the entire application lifecycle, the singleton dependency will be shared across all instances of the prototype

### Interview Questions

#### What is the bean life cycle in Spring Bean Factory Container?
The bean life cycle in Spring includes instantiation, property population, calling the custom init() method, and then being ready to use. When the bean is shut down, it calls its destroy() method for cleanup


#### What is a Spring Bean?
A Spring Bean is a Java class that is initialized by the Spring IoC container. 

#### What is Spring IoC Container?
The Spring IoC container manages the life cycle of Spring Beans, bean scopes, and injecting dependencies into the bean.

#### What is bean scope?

A bean scope defines the lifecycle and visibility of a bean within the Spring IoC container. Some examples of bean scopes include `Singleton`, `Prototype`,`Session`

####  What is dependency injection?

Dependency injection is the concept where you do not create your objects but describe how they should be created, and then expect pre-created objects to be passed in. Likewise, you don’t directly connect your components together but describe which components are needed with either a configuration file or an annotation. The Spring container is responsible for the rest.

DI can be either constructor based or setter based. Constructor based DI is accomplished when the container invokes a class constructor with a number of arguments, each representing a dependency on other classes. Setter based dependency injection is accomplished when the container calls setter methods on a bean after instantiating it.