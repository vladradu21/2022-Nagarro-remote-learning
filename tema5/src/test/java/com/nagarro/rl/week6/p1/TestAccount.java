package com.nagarro.rl.week6.p1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestAccount {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("Vlad", 12345, 1000.0f);
    }

    @ParameterizedTest
    @CsvSource({
            "500.0, 1500.0",
            "-500.0, 1000.0"
    })
    void testDeposit(float amount, float expectedBalance) {
        account.deposit(amount);

        assertEquals(expectedBalance, account.getBalance(), 0.001f);
    }


    @ParameterizedTest
    @CsvSource({
            "500.0, 10.0, 490.0, true",
            "-500.0, 10.0, 1000.0, false",
            "500.0, -10.0, 1000.0, false"
    })
    void testWithdraw(float amount, float fee, float expectedBalance, boolean expectedResult) {
        boolean actualResult = account.withdraw(amount, fee);

        assertEquals(expectedBalance, account.getBalance(), 0.001f);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testAddInterest() {
        account.addInterest();
        assertEquals(1045.0f, account.getBalance(), 0.001f);
    }

    @Test
    void testGetBalance() {
        assertEquals(1000.0f, account.getBalance(), 0.001f);
    }

    @Test
    void testGetAccountNumber() {
        assertEquals(12345, account.getAccountNumber());
    }

    @Test
    void testToString() {
        assertEquals("12345\tVlad\t£1,000.00", account.toString());
    }
}
