package com.general.problems;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

public class LinkedListProblemsTests {

    private LinkedListProblems problems = new LinkedListProblems();

    @Test
    public void testFindMiddleLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        Optional<Integer> middle = problems.findMiddleNodeOfSingleLinkedList(linkedList);
        Assert.assertTrue(middle.get() == 4);

    }

    @Test
    public void testFindMiddleLinkedListWithEvenList() {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8}));
        Optional<Integer> middle = problems.findMiddleNodeOfSingleLinkedList(linkedList);
        Assert.assertTrue(middle.get() == 4);

    }

    @Test
    public void testFindMiddleLinkedListWithNull() {
        Optional<Integer> middle = problems.findMiddleNodeOfSingleLinkedList(null);
        Assert.assertFalse(middle.isPresent());

    }
    @Test
    public void testFindMiddleLinkedListWithOneElement() {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(new Integer[]{1}));
        Optional<Integer> middle = problems.findMiddleNodeOfSingleLinkedList(linkedList);
        Assert.assertTrue(middle.get() == 1);

    }
    @Test
    public void testFindMiddleLinkedListWithTwoElement() {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(new Integer[]{1, 2}));
        Optional<Integer> middle = problems.findMiddleNodeOfSingleLinkedList(linkedList);
        Assert.assertTrue(middle.get() == 1);

    }
}
