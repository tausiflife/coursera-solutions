package com.general.ood.gsf.board;

import com.general.ood.gsf.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int height;
    private int width;
    private List<ArrayList<Tile>> tiles;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        initialize();
    }

    private void initialize() {
        this.tiles = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            ArrayList<Tile> list = new ArrayList<>(height);
            tiles.add(i, list);
            for (int j = 0; j < height; j++) {
                list.add(i, new Tile());
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tile getTile(int x, int y) {
        return tiles.get(x - 1).get(y - 1);
    }

    public void addUnit(Unit unit, int x, int y) {
        Tile tile = getTile(x, y);
        tile.addUnit(unit);
    }

    public void removeUnit(Unit unit, int x, int y) {
        Tile tile = getTile(x, y);
        tile.removeUnit(unit);
    }

    public void removeUnits(int x, int y) {
        Tile tile = getTile(x, y);
        tile.removeUnits();
    }

    public Unit getUnits(int x, int y) {
        Tile tile = getTile(x, y);
        return tile.getUnits();
    }
}
