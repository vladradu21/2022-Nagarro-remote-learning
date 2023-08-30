package com.nagarro.rl.week7.p3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TitlelizerImplTest {

    private Titlelizer titlelizer;

    @Before
    public void setUp() {
        //instantiate the object you want to test
        titlelizer = new TitlelizerImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTitlelizeForNullShouldThrowException() throws Exception {
        titlelizer.titlelize(null);
    }
    @Test
    public void testTitlelizeForEmptyStringShouldReturnEmptyString() {
        //WHEN
        String actualResult = titlelizer.titlelize("");

        //THEN
        assertThat(actualResult, is(" "));
    }

    @Test
    public void testTitlelizeForTitlelizedString() throws Exception {
        //WHEN
        String actualResult = titlelizer.titlelize("Already Titlelized String");

        //THEN
        assertThat(actualResult, is("Already Titlelized String"));
    }

    @Test
    public void testTitlelizeShouldIgnorePrepositionsString() throws Exception {
        //WHEN
        String actualResult = titlelizer.titlelize("This String is Titlelized");

        //THEN
        assertThat(actualResult, is("This String is Titlelized"));
    }

    @Test
    public void testTitlelizeWhenFirsWordIsPreposition() throws Exception {
        //WHEN
        String actualResult = titlelizer.titlelize("this String is Titlelized");

        //THEN
        assertThat(actualResult, is("This String is Titlelized"));
    }

    @Test
    public void testTitlelize() throws Exception {
        //WHEN
        String actualResult = titlelizer.titlelize("please titlelize me");

        //THEN
        assertThat(actualResult, is("Please Titlelize Me"));
    }
}
