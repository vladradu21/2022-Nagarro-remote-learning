package com.nagarro.rl.week7.p2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateConverterTest {

    @Test
    void generateDateValid() {
        LocalDate date = LocalDate.of(2023, 2, 24);
        String expected = "FRIDAY FEBRUARY 2023";
        assertEquals(expected, DateConverter.generateDate(date));
    }

    @Test
    void generateDateValid2() {
        LocalDate date = LocalDate.of(2023, 10, 17);
        String expected = "TUESDAY OCTOBER 2023";
        assertEquals(expected, DateConverter.generateDate(date));
    }
}