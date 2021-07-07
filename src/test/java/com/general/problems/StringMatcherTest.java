package com.general.problems;

import com.general.algorithms.StringMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringMatcherTest {
    private StringMatcher stringMatcher = new StringMatcher();

    @Test
    public void testIsSubstring() {
        assertTrue(stringMatcher.isSubString("abc", "bc"));
    }

    @Test
    public void testSubstringWithNullMatchingString() {
        assertFalse(stringMatcher.isSubString("abc", null));
    }

    @Test
    public void testSubstringWithNullOriginalString() {
        assertFalse(stringMatcher.isSubString(null, "abc"));
    }

    @Test
    public void testSubstringFalse() {
        assertFalse(stringMatcher.isSubString("abcde", "cdh"));
    }
}
