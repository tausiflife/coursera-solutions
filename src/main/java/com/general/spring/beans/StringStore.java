package com.general.spring.beans;

public class StringStore implements Store<String> {
    @Override
    public void whoAmI() {
        System.out.println("I am string store");
    }
}
