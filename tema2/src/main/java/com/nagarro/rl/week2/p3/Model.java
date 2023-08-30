package com.nagarro.rl.week2.p3;

public class Model extends SuperModel {

    private String modelName;

    static {
        System.out.println("static Model");
    }

    {
        System.out.println("fields Model");
    }

    public Model() {
        super("No superName");
        modelName = "No moduleName";
        System.out.println("No arguments constructor");
    }

    public Model(String name, String superName) {
        super(superName);
        modelName = name;
        System.out.println("2 arguments constructor: " + name + ", " + superName);
    }

    @Override
    public String toString() {
        return super.toString() + ", modelName= " + modelName;
    }
}
