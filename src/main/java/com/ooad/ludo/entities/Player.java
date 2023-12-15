package com.ooad.ludo.entities;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private Yard yard;
    private Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.id = UUID.randomUUID().toString();
        this.yard = new Yard(color);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color);
    }
}
