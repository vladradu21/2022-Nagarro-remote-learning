package com.nagarro.rl.week5.p1;

public class Main {
    public static void main(String[] args) {
        try {
            throw new MyException("My exception message!");
        } catch (MyException e) {
            e.displayMessage();
        }
    }
}
