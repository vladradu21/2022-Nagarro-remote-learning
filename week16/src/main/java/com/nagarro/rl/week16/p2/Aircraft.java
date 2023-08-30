package com.nagarro.rl.week16.p2;

public class Aircraft extends Vehicle {
    private int numEngines;

    public Aircraft(String make, int year, int numEngines) {
        super(make, year);
        this.numEngines = numEngines;
    }

    public int getNumEngines() {
        return numEngines;
    }

    public void fly() {
        System.out.println("Aircraft is flying");
    }
}
