package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sound.midi.Track;
@Component
public class Traveler {
//    Car car = null;
//    Bike bike = null;
//    Cycle cycle = null;

    private Vehicle vehicle;

    // Traveler Class/Object/Constructor requires a Vehicle Object as an argument
    @Autowired
    //public Traveler(@Qualifier("car") Vehicle vehicle){     //@Qualifier defines which bean to actually use as a Vehicle
    public Traveler(Vehicle vehicle){   //-- @Primary has prioritised Car class. Therefore no need to specify which bean to use.
//        this.car = new Car();
//        this.bike = new Bike();
//        this.cycle = new Cycle();
        this.vehicle = vehicle;

    }

    public void startJourney(){
//        this.car.move();
//        this.bike.move();
//        this.cycle.move();

        // The vehicle's (Car/Bike/Cycle) methods are accessed through the interface Vehicle.
        this.vehicle.move();
    }
}
