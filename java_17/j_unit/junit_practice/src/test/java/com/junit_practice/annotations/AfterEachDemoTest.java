package com.junit_practice.annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit_practice.Calculator;

public class AfterEachDemoTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("setUp method calling..");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("tearDown method calling..");
    }

    @DisplayName("Test Addition of Two Numbers")
    @Test
    void addTest() {

        int addition = calculator.add(2, 2);

        assertEquals(4, addition);
        System.out.println("addTest method calling..");
    }

    @DisplayName("Test Subtraction of Two Numbers 😅 @#$(*&) \u00C6 \u00C6 \u00C6")
    @Test
    void subtractTest() {

        int subtract = calculator.subtract(2, 2);

        assertEquals(0, subtract);
        System.out.println("subtractTest method calling..");
    }

    @Disabled("Disabled until code is added")
    @DisplayName("Test Divide Method of two numbers")
    @Test
    void testDivide() {

        // TODO: add code
    }

    @Disabled
    @Test
    void testMultiply() {

        // TODO: add code
    }

}
