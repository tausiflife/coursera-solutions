package com.general.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public class LinkedListProblems {

    public Optional<Integer> findMiddleNodeOfSingleLinkedList(LinkedList<Integer> linkedList) {
        if (linkedList == null)
            return Optional.ofNullable(null);
        Iterator<Integer> slow = linkedList.iterator();
        Iterator<Integer> fast = linkedList.iterator();
        Integer middle = null;
        while (fast.hasNext()) {
            middle = slow.next();
            fast.next();
            if (fast.hasNext())
                fast.next();

        }
        return Optional.ofNullable(middle);
    }


}
