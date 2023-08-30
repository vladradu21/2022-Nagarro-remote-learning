package com.nagarro.rl.week6.p3.plant.initial.domain;

public class Engine {
    
    private EngineArchitecture engineArchitecture;
    private double displacement;
    private int horsePower;

    public Engine(EngineArchitecture engineArchitecture, double displacement, int horsePower) {
        this.engineArchitecture = engineArchitecture;
        this.displacement = displacement;
        this.horsePower = horsePower;
    }

    public EngineArchitecture getEngineArchitecture() {
        return engineArchitecture;
    }

    public double getDisplacement() {
        return displacement;
    }

    public int getHorsePower() {
        return horsePower;
    }
}
