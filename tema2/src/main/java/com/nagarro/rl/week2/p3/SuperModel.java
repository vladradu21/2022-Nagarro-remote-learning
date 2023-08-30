package com.nagarro.rl.week2.p3;

public class SuperModel {

    private String superModelName;

    static {
        System.out.println("Static SuperModel");
    }

    {
        System.out.println("fields SuperModel");
    }

    public SuperModel(String name) {
        superModelName = name;
        System.out.println("super constructor Model");
    }

    @Override
    public String toString() {
        return "superModelName= " + superModelName;
    }
}
