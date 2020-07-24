package com.digitalacademy.unittestwithjunit5.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void testMultiply(){
        assertEquals(4, calculator.multiply(2, 2));
        assertEquals(48, calculator.multiply(6, 8));
    }

    @Test
    void testDivide(){
        assertEquals(1, calculator.divide(5, 5));
        assertEquals(2, calculator.divide(8, 4));
    }
}
