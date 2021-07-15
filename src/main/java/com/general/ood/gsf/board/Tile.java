package com.general.ood.gsf.board;

import com.general.ood.gsf.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private List<Unit> units;

    public Tile() {
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
    }

    public Unit getUnits() {
        return null;
    }

    public void removeUnits() {

    }
}
