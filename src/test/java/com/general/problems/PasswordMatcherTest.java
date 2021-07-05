package com.general.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordMatcherTest {
    private PasswordMatcher passwordMatcher = new PasswordMatcher();
    @Test
    public void testMatcher() {
        Assertions.assertEquals(1, passwordMatcher.match(new String[]{"abcd", "cdab"}));
        Assertions.assertEquals(2, passwordMatcher.match(new String[]{"abcd", "cdab", "bacd"}));
        Assertions.assertEquals(4, passwordMatcher.match(new String[]{"abcd", "acbd", "adcb", "cdba",
                "bcda", "badc"}));

    }
}
