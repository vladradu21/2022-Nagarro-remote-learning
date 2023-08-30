package com.nagarro.rl.week2.p2;

public class Main {

    public static void main(String[] args) {
        Tank t1 = new Tank();
        t1.fillTank();
        t1.fillTank();
        t1.emptyTank();
        t1.emptyTank();

        t1 = null;
        System.gc();


        Tank t2 = new Tank();
        t2 = t1;
        System.gc();

        new Tank();
        System.gc();
    }
}
