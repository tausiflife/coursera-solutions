package com.ooad.mastermind.dao;

import com.ooad.mastermind.entities.Game;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMasterMindDao implements MasterMindDao {
    private static final Map<String, Game> games = new HashMap<>();

    @Override
    public Game saveGame(Game game) {
        return games.put(game.getId(), game);
    }

    @Override
    public Game getGame(String id) {
        return games.get(id);
    }
}
