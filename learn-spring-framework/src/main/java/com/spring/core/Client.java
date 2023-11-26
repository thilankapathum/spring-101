package com.spring.core;

public class Client {
    public static void main(String[] args) {

        // Creating a Car Object using interface type, Vehicle
        Vehicle vehicle = new Car();
//        vehicle = new Cycle();

//        Vehicle vehicle = new Bike();  //Can substitute Car Object into a Bike Object like this

        // New traveller Object is created using the newly created Car Object (via Vehicle instance).
        // Traveler's constructor requires a Vehicle Object as an argument.
        Traveler traveler = new Traveler(vehicle);
        traveler.startJourney();
    }
}
