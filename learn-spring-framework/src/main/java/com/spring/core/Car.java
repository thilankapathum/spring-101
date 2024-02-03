package com.spring.core;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // Annotation based configuration
// @Component("car")    <- We can explicitly define the bean name as "car". Otherwise Spring IOC will automatically give the bean a name.
@Primary    //-- Give higher priority to this bean (from multiple beans).
public class Car implements Vehicle{
    @Override
    public void move(){
        System.out.println("Car is moving");
    }
}
