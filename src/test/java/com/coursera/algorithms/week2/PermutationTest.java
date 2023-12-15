package com.coursera.algorithms.week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PermutationTest {

    @Test
    public void testPermutation() {
        Permutation permutation = new Permutation();
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,4,3,2,1};
        Assertions.assertTrue(permutation.isArrayPermutation(arr1,arr2));
    }

    @Test
    public void testPermutation_fail_unequal_length() {
        Permutation permutation = new Permutation();
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {5,4,3,2,1};
        Assertions.assertFalse(permutation.isArrayPermutation(arr1,arr2));
    }

    @Test
    public void testPermutation_fail_different_values() {
        Permutation permutation = new Permutation();
        int[] arr1 = {1,2,3,4,6};
        int[] arr2 = {5,4,3,2,1};
        Assertions.assertFalse(permutation.isArrayPermutation(arr1,arr2));
    }

    @Test
    public void testPermutation_fail_different__repeated_values() {
        Permutation permutation = new Permutation();
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,4,3,2,5};
        Assertions.assertFalse(permutation.isArrayPermutation(arr1,arr2));
    }
}
