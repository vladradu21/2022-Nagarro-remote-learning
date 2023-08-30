package com.nagarro.rl.week16.p2;

public class Vehicle {
    private String make;
    private int year;

    public Vehicle(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public void start() {
        System.out.println("Vehicle started");
    }
}
