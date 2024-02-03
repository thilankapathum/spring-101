package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // -- Java based Configuration
@ComponentScan(basePackages = "com.spring.core")    // Specify the package name. Spring IoC Container will scan this...
                                                    // ...package and create Spring beans according to @Component annotation.
public class AppConfig {



/*  -- Java Based Configuration --

    @Bean
    public Vehicle car(){
        return new Car();
    }
    @Bean
    public Vehicle bike(){
        return new Bike();
    }
    @Bean
    public Vehicle cycle(){
        return new Cycle();
    }
    @Bean
    public Traveler traveler(){
        return new Traveler(car()); // Dependency Injection (Injecting car() object to traveler() object)
    }
*/

}
