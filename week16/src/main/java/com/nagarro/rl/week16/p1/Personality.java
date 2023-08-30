package com.nagarro.rl.week16.p1;

import java.util.Objects;

public class Personality {

    private String fname;
    private String lname;
    private Integer dob;
    private Integer dod;

    public Personality(String fname, String lname, Integer dob, Integer dod) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.dod = dod;
    }

    public Personality(String fname, String lname, Integer dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    public String getName() {
        return fname + " " + lname;
    }

    @Override
    public String toString() {
        return "fname= " + fname + ", lname= " + lname + ", dob= " + dob + ", dod= " + dod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personality that = (Personality) o;
        return Objects.equals(fname, that.fname) && Objects.equals(lname, that.lname) && Objects.equals(dob, that.dob) && Objects.equals(dod, that.dod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname, dob, dod);
    }
}
