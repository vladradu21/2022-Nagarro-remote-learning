package com.nagarro.rl.week7.p2;

import java.time.LocalDate;

public class DateConverter {

    public enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public enum MonthName  {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static String  generateDate(LocalDate date) {
        Weekday weekday = Weekday.valueOf(date.getDayOfWeek().name());
        MonthName monthName = MonthName.valueOf(date.getMonth().name());
        int year = date.getYear();

        return weekday + " " + monthName + " " + year;
    }
}
