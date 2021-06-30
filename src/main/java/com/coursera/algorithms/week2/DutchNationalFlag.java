package com.coursera.algorithms.week2;

public class DutchNationalFlag {

    public int[] sort(int[] arr) {
        int i =0, r = 0, b = arr.length - 1;
        while (i < b) {
            int color = arr[i];
            if (color == 0) { // red pebble
                swap(arr, i, r);
                r++;
                i++;
            } else if (color == 1) {//white pebble
                i++;
            } else if (color == 2 ){
                swap(arr, i, b);
                b--;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int r) {
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
    }
}
