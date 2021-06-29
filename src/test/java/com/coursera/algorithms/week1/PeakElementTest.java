package com.coursera.algorithms.week1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PeakElementTest {

    private PeakElement peakElement = new PeakElement();

    @Test
    public void findPeakElement() {
        int[] arr = {1,3,5,9,7};
        int peakIndex = peakElement.findPeak(arr);
        Assertions.assertEquals(3, peakIndex);
    }
    @Test
    public void findPeakElementAtStart() {
        int[] arr = {9,7,6,5};
        int peakIndex = peakElement.findPeak(arr);
        Assertions.assertEquals(0, peakIndex);
    }

    @Test
    public void findPeakElementAtEnd() {
        int[] arr = {2,4,6,8};
        int peakIndex = peakElement.findPeak(arr);
        Assertions.assertEquals(3, peakIndex);
    }

    @Test
    public void findPeakElementWithOneElementArray() {
        int[] arr = {2};
        int peakIndex = peakElement.findPeak(arr);
        Assertions.assertEquals(0, peakIndex);
    }

    @Test
    public void findPeakElementInBitonicArray() {
        int[] arr = {1,3,5,9,7,6,4,2};
        int peakIndex = peakElement.findPeak(arr);
        Assertions.assertEquals(3, peakIndex);
    }
}

class QueueOfItem<T> {
    T[] data ;

        }
