package com.ooad.mastermind.entities;

import lombok.Getter;
import org.junit.Assert;

@Getter
public class CodePeg {
    private String color;

    public CodePeg(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
