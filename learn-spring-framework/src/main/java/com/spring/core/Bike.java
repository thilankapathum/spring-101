package com.spring.core;

import org.springframework.stereotype.Component;

@Component // Annotation based configuration
public class Bike implements Vehicle{
    @Override
    public void move(){
        System.out.println("Bike is moving!");
    }
}
