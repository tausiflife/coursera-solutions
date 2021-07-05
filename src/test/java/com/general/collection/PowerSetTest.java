package com.general.collection;

import com.general.problems.PowerSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PowerSetTest {

    @Test
    public void testPowerSet() {
        PowerSet<String> powerSet = new PowerSet<>();
        Set<String> stringSet = new HashSet<>(Arrays.asList(new String[]{"a", "b", "c"}));
        Set<Set<String>> output = powerSet.powerSet(stringSet);

        Assertions.assertEquals(8, output.size());
        Assertions.assertTrue(output.contains(stringSet));
        Assertions.assertTrue(output.contains(new HashSet<>()));
        Assertions.assertTrue(output.contains(new HashSet<>(Arrays.asList(new String[]{"a"}))));
        Assertions.assertTrue(output.contains(new HashSet<>(Arrays.asList(new String[]{"b"}))));
        Assertions.assertTrue(output.contains(new HashSet<>(Arrays.asList(new String[]{"c"}))));
        Assertions.assertTrue(output.contains(new HashSet<>(Arrays.asList(new String[]{"a", "b"}))));
        Assertions.assertTrue(output.contains(new HashSet<>(Arrays.asList(new String[]{"a", "c"}))));
        Assertions.assertTrue(output.contains(new HashSet<>(Arrays.asList(new String[]{"b", "c"}))));
        Assertions.assertTrue(output.contains(new HashSet<>(Arrays.asList(new String[]{"a", "b", "c"}))));

    }
}
