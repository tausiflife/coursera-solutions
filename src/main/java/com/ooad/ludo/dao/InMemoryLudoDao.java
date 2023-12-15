package com.ooad.ludo.dao;

import com.ooad.ludo.entities.LudoGame;

import java.util.HashMap;
import java.util.Map;

public class InMemoryLudoDao implements LudoDao {

    private static final Map<String, LudoGame> games = new HashMap<>();
    @Override
    public boolean saveGame(LudoGame game) {
        games.put(game.getId(), game);
        return true;
    }

    @Override
    public LudoGame getGame(String id) {
        return games.get(id);
    }
}
