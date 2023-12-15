package com.ooad.mastermind.dao;

import com.ooad.mastermind.entities.Game;

public interface MasterMindDao {

    Game saveGame(Game game);

    Game getGame(String id);
}
