package com.junit_practice.annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.junit_practice.Factorial;

// test classes cannot be protected
public class FactorialTest {
    @Test
    public void factorialTest() {

        Factorial factorial = new Factorial();
        int actualResult = factorial.factorial(5);

        assertEquals(120, actualResult);

    }
}
