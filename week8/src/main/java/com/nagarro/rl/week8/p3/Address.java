package com.nagarro.rl.week8.p3;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Address {

    @JsonProperty("city")
    private String city;

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("addressLine")
    private String addressLine;

    public Address() {
        // Default constructor
    }

    public Address(String city, String zipcode, String addressLine) {
        this.city = city;
        this.zipcode = zipcode;
        this.addressLine = addressLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(zipcode, address.zipcode) && Objects.equals(addressLine, address.addressLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, zipcode, addressLine);
    }
}

