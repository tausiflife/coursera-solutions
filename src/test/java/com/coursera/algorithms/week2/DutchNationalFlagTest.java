package com.coursera.algorithms.week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DutchNationalFlagTest {

    @Test
    public void testDutchNationalFlag() {
        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        int[] arr = {0,0,1,2,0,1,0,2,2,0,1};
        dutchNationalFlag.sort(arr);
        Assertions.assertArrayEquals(new int[]{0,0,0,0,0,1,1,1,2,2,2}, arr);

    }
}
