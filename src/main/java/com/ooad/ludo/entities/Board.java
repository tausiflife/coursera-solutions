package com.ooad.ludo.entities;

import java.util.Map;
import java.util.UUID;

public class Board {
    private String id;
    private Map<Player, Step> playersInitialStep;

    public Board() {
        this.id = UUID.randomUUID().toString(); 
    }
}
