package com.general.collection;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTypeSafety {

    @Test
    public void testClassCastExceptionWhileGettingValue() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            addtolist(list);
            Integer i = list.get(2);
        });
        Assert.assertEquals(ClassCastException.class, exception.getClass());
    }

    private void addtolist(List list) {
        list.add("hello"); //OK
    }


    @Test
    public void testCheckedCollection() {
        //ClassCast exception while adding values
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            List<Integer> list = new ArrayList<>();
            list = Collections.checkedList(list, Integer.class);
            list.add(1);
            list.add(2);
            addtolist(list);
        });
        Assert.assertEquals(ClassCastException.class, exception.getClass());
    }
}
