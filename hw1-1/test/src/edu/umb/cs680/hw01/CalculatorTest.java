package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    public void test_multiply3By4(){
        Calculator cut = new Calculator();
        float expected = 12;
        float actual = cut.multiply(3, 4);
        assertEquals(actual, expected);
    }

    @Test
    public void test_divide3By2(){
        Calculator cut = new Calculator();
        float expected = 1.5f;
        float actual = cut.divide(3, 2);
        assertEquals(actual, expected);
    }

    @Test
    public void test_divide5By0() /*throws IllegalArgumentException*/ {
        Calculator cut = new Calculator();
        try {
            cut.divide(5, 0);
        } catch (IllegalArgumentException e) {
            //Do nothing.
        }
    }

    @Test
    public void test_multiply2_5By5_5(){
        Calculator cut = new Calculator();
        float expected = 13.75f;
        float actual = cut.multiply(2.5f, 5.5f);
        assertEquals(actual, expected);
    }

    @Test
    public void test_divide2_5By5_0(){
        Calculator cut = new Calculator();
        float expected = 0.5f;
        float actual = cut.divide(2.5f, 5.0f);
        assertEquals(actual, expected);
    }
}

