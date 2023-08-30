package com.nagarro.rl.week10.p1;

import java.util.Comparator;
import java.util.Objects;

public class Country implements Comparable<Country> {
    private String name;
    private String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public int compareTo(Country other) {
        return this.name.compareTo(other.getName());
    }

    public static class CapitalComparator implements Comparator<Country> {
        @Override
        public int compare(Country c1, Country c2) {
            return c1.getCapital().compareTo(c2.getCapital());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(capital, country.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital);
    }
}
