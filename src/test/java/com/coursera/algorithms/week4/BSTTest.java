package com.coursera.algorithms.week4;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class BSTTest {
    private BST<Integer, Integer> bst = new BST<>();

    @BeforeEach
    void setUp() {
        bst.put(20, 20);
        bst.put(25, 25);
        bst.put(6, 6);
        bst.put(4, 4);
        bst.put(9, 9);
        bst.put(8, 8);
        bst.put(12, 12);
        bst.put(30, 30);
        bst.put(21, 21);
    }

    @Test
    public void shouldGetValueForKey() {
        Assert.assertTrue(8 ==bst.get(8));
        Assert.assertTrue(20 ==bst.get(20));
    }
    @Test
    public void shouldGetMinKey() {
        Assert.assertTrue(4 ==bst.min());
    }
    @Test
    public void shouldGetMaxKey() {
        Assert.assertTrue(30 == bst.max());
    }
    @Test
    public void shouldFindFloor() {
        Assert.assertTrue(4 == bst.floor(5));
        Assert.assertTrue(21 == bst.floor(23));
        Assert.assertTrue(30 == bst.floor(30));
    }

    @Test
    public void shouldFindCeiling() {
        Assert.assertTrue(6 == bst.ceiling(5));
        Assert.assertTrue(25 == bst.ceiling(23));
        Assert.assertTrue(20 == bst.ceiling(20));
    }

    @Test
    public void shouldInvertABinaryTree() {
        bst.invert();
        System.out.println("P".compareTo("R"));
    }

    @Test
    void testRangeSearchBinaryTree() {
        Set<Integer> integerSet = bst.rangeSearch(7, 22);
        Assert.assertEquals(5, integerSet.size());
    }

    @Test
    void shouldTestContains() {
        boolean yes = bst.contains(20);
        Assert.assertTrue(yes);
    }

    @Test
    void shouldTestDoesntContains() {
        boolean no = bst.contains(50);
        Assert.assertFalse(no);
    }
}
