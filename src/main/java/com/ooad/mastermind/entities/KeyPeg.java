package com.ooad.mastermind.entities;

import lombok.Getter;

@Getter
public class KeyPeg {

    private KeyPegColor color;

    public KeyPeg(KeyPegColor color) {
        this.color = color;
    }

    public KeyPegColor getColor() {
        return color;
    }
}
