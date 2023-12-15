package com.general.spring.beans;

public class IntegerStore implements Store<Integer> {
    @Override
    public void whoAmI() {
        System.out.println("I am integer store");
    }
}
