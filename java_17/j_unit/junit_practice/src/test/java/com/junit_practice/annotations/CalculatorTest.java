package com.junit_practice.annotations;

import org.junit.jupiter.api.Test;

import com.junit_practice.Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

// @Disabled // this annotation can disable either a whole class of tests or individual test
// methods
@DisplayName("Calculator Operations Test")
public class CalculatorTest {

    @DisplayName("Test Addition of Two Numbers")
    @Test
    void addTest() {

        Calculator calculator = new Calculator();
        int addition = calculator.add(2, 2);

        assertEquals(4, addition);
    }

    @DisplayName("Test Subtraction of Two Numbers 😅 @#$(*&) \u00C6 \u00C6 \u00C6")
    @Test
    void subtractTest() {

        Calculator calculator = new Calculator();
        int subtract = calculator.subtract(2, 2);

        assertEquals(0, subtract);
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
