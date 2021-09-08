package com.coursera.algorithms.week4;

import org.junit.jupiter.api.Test;

public class Week4ProblemsTests {

    @Test
    void testTaxiCabNumbers() {
        Week4Problems week4Problems = new Week4Problems();
        week4Problems.taxiCabNumber(1000);
    }

    @Test
    void checkCompressed() {
        Week4Problems week4Problems = new Week4Problems();
        int i = week4Problems.checkCompressed("GEEKSFORGEEKS", "12S");
        System.out.println(i);
    }
}
