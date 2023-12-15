package com.ooad.ludo.entities;

import java.util.Objects;
import java.util.UUID;

public class Token {
    private String id;
    private Color color;

    public Token(Color color) {
        this.color = color;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(id, token.id) && color == token.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color);
    }
}
