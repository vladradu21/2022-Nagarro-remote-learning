package com.nagarro.rl.week8.p1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorInvocationHandlerTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        CalculatorImpl calculatorImpl = new CalculatorImpl();
        CalculatorInvocationHandler handler = new CalculatorInvocationHandler(calculatorImpl, new Logger(true));

        calculator = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[]{Calculator.class},
                handler
        );
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(5, 4));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(8, 4));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(8, 0));
    }
}
