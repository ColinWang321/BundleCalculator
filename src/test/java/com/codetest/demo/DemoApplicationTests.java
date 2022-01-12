package com.codetest.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DemoApplicationTests {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    void testIndexOfFunction() {
        String[] strArray = {"Jan", "Feb", "March", "Apr", "May"};

        Assertions.assertEquals(0, calculator.indexOf(strArray, "Jan"));
        Assertions.assertEquals(4, calculator.indexOf(strArray, "May"));
        Assertions.assertEquals(2, calculator.indexOf(strArray, "March"));
        Assertions.assertEquals(3, calculator.indexOf(strArray, "Apr"));
        Assertions.assertEquals(1, calculator.indexOf(strArray, "Feb"));

    }

    @Test
    void testBundleCalculatorFunction() {
        Calculator calculator = new Calculator();
        BundleInfo bundleInfo = new BundleInfo();
        OrderItem orderItem = new OrderItem(16, "IMG");
        ArrayList<Integer> bestBundles = new ArrayList<>();
        bestBundles.add(1);
        bestBundles.add(2);

        Assertions.assertEquals(bestBundles, calculator.bundleCalculator(orderItem, bundleInfo));

    }

}
