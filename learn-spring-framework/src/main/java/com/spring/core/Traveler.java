package com.spring.core;

import javax.sound.midi.Track;

public class Traveler {
//    Car car = null;
//    Bike bike = null;
//    Cycle cycle = null;

    private Vehicle vehicle;

    // Traveler Class/Object/Constructor requires a Vehicle Object as an argument
    public Traveler(Vehicle vehicle){
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
