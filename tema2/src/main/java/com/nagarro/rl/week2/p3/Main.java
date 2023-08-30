package com.nagarro.rl.week2.p3;

public class Main {

    static {
        System.out.println("static block in Main");
    }

    {
        System.out.println("local variables in Main");
    }

    public static void main(String[] args) {

        Model m1 = new Model();
        System.out.println(m1);
        System.out.println("Done with m1\n");

        Model m2 = new Model("m2", "superM2");
        System.out.println(m2);
    }
}
