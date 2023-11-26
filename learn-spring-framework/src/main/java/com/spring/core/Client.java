package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {

        // Creating a Car Object using interface type, Vehicle
        // Vehicle vehicle = new Car();

        // vehicle = new Cycle();
        // Vehicle vehicle = new Bike();  //Can substitute Car Object into a Bike Object like this

        // New traveller Object is created using the newly created Car Object (via Vehicle instance).
        // Traveler's constructor requires a Vehicle Object as an argument.
        // Traveler traveler = new Traveler(vehicle);
        // traveler.startJourney();

        // Creating Spring IOC container.
        // Spring IOC container will read AppConfig.class for required dependencies/configurations
        // Based on configuration it'll create and manage Spring beans
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Spring beans from Spring IOC container
        Car car = applicationContext.getBean(Car.class);
        car.move();

        Bike bike = applicationContext.getBean(Bike.class);
        bike.move();

        Traveler traveler1 = applicationContext.getBean(Traveler.class);
        traveler1.startJourney();


    }
}
