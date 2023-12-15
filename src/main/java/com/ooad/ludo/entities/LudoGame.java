package com.ooad.ludo.entities;

import java.util.List;

public class LudoGame {
    private String id;
    private Board board;
    private Player[] players;
    public LudoGame(List<String> playerNames) {
        if(playerNames == null || playerNames.size() < 2 || playerNames.size() > 4)
            throw new IllegalArgumentException("Game player has to be between 2 and 4.");
        this.players = new Player[playerNames.size()];
        for (int i = 0; i< playerNames.size(); i++) {
            this.players[i] = new Player(playerNames.get(i), Color.values()[i]);
        }
        this.board = new Board();
    }

    public String getId() {
        return id;
    }
}
