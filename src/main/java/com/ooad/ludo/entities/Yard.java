package com.ooad.ludo.entities;

public class Yard {
    private Token[] tokens;

    public Yard(Color color) {
        tokens = new Token[4];
        for (int i = 0; i< 4; i++)
            tokens[i] = new Token(color);
    }

    public Token getToken(int id) {
        if (id < 0 || id > 4)
            throw new IllegalArgumentException("Token not found");
        return tokens[id];
    }
}
