package com.nagarro.rl.week2.p1;

import java.util.Arrays;

public class Person {
    private String surname;
    private String[] firstName;

    public Person(String surname, String firstName) {
        this.surname = surname;
        this.firstName = firstName.split(" ");
    }

    public Person(String fullName) {
        String attributes[] = fullName.split(" ", 2);
        surname = attributes[0];
        firstName = attributes[1].split(" ");
    }

    @Override
    public String toString() {
        return "surname= " + surname + ", firstName= " + Arrays.toString(firstName);
    }
}
