package com.nagarro.rl.week2.p2;

public class Tank {
    private boolean isFull;

    public Tank() {
    }

    public void fillTank() {
        if(isFull) {
            System.out.println("Tank already filled!");
        } else {
            isFull = true;
            System.out.println("Full tank!");
        }
    }

    public void emptyTank() {
        if(!isFull) {
            System.out.println("Tank already emptied!");
        } else {
            isFull = false;
            System.out.println("Empty tank!");
        }
    }

    @Override
    public void finalize() {
        if(isFull) {
            System.out.println("This tank is not empty!");
        } else {
            System.out.println("Object is done!");
        }
    }
}
