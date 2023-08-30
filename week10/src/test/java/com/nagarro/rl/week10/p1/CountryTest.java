package com.nagarro.rl.week10.p1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    private List<Country> countries;

    @BeforeEach
    public void setUp() {
        countries = new ArrayList<>();
        countries.add(new Country("Italy", "Rome"));
        countries.add(new Country("Spain", "Madrid"));
        countries.add(new Country("Germany", "Berlin"));
        countries.add(new Country("France", "Paris"));
    }

    @Test
    public void testSortByName() {
        // sort by name
        Collections.sort(countries);
        assertEquals("France", countries.get(0).getName());
        assertEquals("Germany", countries.get(1).getName());
        assertEquals("Italy", countries.get(2).getName());
        assertEquals("Spain", countries.get(3).getName());
    }

    @Test
    public void testSortByCapital() {
        // sort by capital
        Collections.sort(countries, new Country.CapitalComparator());
        assertEquals("Berlin", countries.get(0).getCapital());
        assertEquals("Madrid", countries.get(1).getCapital());
        assertEquals("Paris", countries.get(2).getCapital());
        assertEquals("Rome", countries.get(3).getCapital());
    }

    @Test
    public void testBinarySearchByCapital() {
        // sort by capital
        Collections.sort(countries, new Country.CapitalComparator());

        // binary search by capital
        int index = Collections.binarySearch(countries, new Country("", "Rome"), new Country.CapitalComparator());
        assertEquals(3, index);
    }

}