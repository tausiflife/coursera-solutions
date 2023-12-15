package com.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

public class TypeSafetyTests {
    @Test
    void testArrayTypeSafety() {

        Assertions.assertThrows(ArrayStoreException.class, () -> {
            Object[] arr = new Integer[10];
            test(arr);
        });
    }

    private void test(Object[] arr) {
        arr[0] = "hello";
    }

    @Test
    public void testTypeSafetyInArrays() {
        Assertions.assertThrows(ClassCastException.class, () -> {
            Object[] o1 = new Object[1];
            o1[0] = 1;
            Number[] n1 = (Number[]) o1;
            Number n = n1[0];
        });

        Object[] integers = new Double[1];
        integers[0] = 1d;
        Number[] numbers = (Number[]) integers;
        Number n = numbers[0];
    }

    @Test
    public void downCastTestFromNumberToObjectArray() {
        Number[] numbers = new Number[1];
        numbers[0] = 1d;
        Object[] objects = (Object[]) numbers;
        Number n = (Number) objects[0];
    }

    @Test
    public void testGenericStacks() {
        Stack<Number> numbers = new Stack<>();
        numbers.push(1);
        nonGenericAddition(numbers);
        Object str = (Object) numbers.pop();
    }

    @Test
    public void testGenericList() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        nonGenericAddition(numbers);
    }

    private void nonGenericAddition(List list) {
        list.add(new Object());
    }

    public void testHeapPollution() {
        List<String> stringListA = new ArrayList<String>();
        List<String> stringListB = new ArrayList<String>();

        addToList(stringListA, "Seven", "Eight", "Nine");
        addToList(stringListB, "Ten", "Eleven", "Twelve");
        List<List<String>> listOfStringLists =
                new ArrayList<List<String>>();
        addToList(listOfStringLists,
                stringListA, stringListB);

        faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));

    }
    private static <T> void addToList (List<T> listArg, T... elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }
    private static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = l[0].get(0);       // ClassCastException thrown here
    }
}
class Employee {

}
class Manager extends Employee {

}
