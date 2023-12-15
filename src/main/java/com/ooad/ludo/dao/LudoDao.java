package com.ooad.ludo.dao;

import com.ooad.ludo.entities.LudoGame;

public interface LudoDao {

    boolean saveGame(LudoGame game);

    LudoGame getGame(String id);
}
