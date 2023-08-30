package com.nagarro.rl.week16.p2;

public class Car extends Vehicle {

    private int numDoors;

    public Car(String make, int year, int numDoors) {
        super(make, year);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void drive() {
        System.out.println("Car is driving");
    }
}
