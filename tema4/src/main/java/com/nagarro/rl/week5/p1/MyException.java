package com.nagarro.rl.week5.p1;

public class MyException extends Exception{
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public void displayMessage() {
        System.out.println(message);
    }
}
