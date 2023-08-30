package com.nagarro.rl.week8.p3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Student {

    @JsonProperty("id")
    private int id;

    @JsonProperty("firstName")
    private String fistName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @JsonProperty("graduated")
    private boolean graduated;

    @JsonProperty("address")
    private Address address;

    public Student() {
        // Default constructor
    }

    public Student(int id, String fistName, String lastName, Date dateOfBirth, boolean graduated, Address address) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.graduated = graduated;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && graduated == student.graduated && Objects.equals(fistName, student.fistName) && Objects.equals(lastName, student.lastName) && Objects.equals(dateOfBirth, student.dateOfBirth) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fistName, lastName, dateOfBirth, graduated, address);
    }
}
