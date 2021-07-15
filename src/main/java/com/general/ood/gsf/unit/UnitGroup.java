package com.general.ood.gsf.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UnitGroup {
    private Map<Integer, Unit> units;

    public UnitGroup(List<Unit> units) {
        this.units = units.stream().collect(Collectors.toMap(u -> u.getId(), Function.identity()));
    }

    public UnitGroup() {
        this(new ArrayList<>());
    }

    public void addUnit(Unit unit) {
        units.put(unit.getId(), unit);
    }

    public void removeUnit(int id) {
        units.remove(id);
    }

    public void removeUnit(Unit unit) {
        removeUnit(unit.getId());
    }

    public Unit getUnit(int id) {
        return units.get(id);
    }

    public List<Unit> getUnits() {
        return units.values().stream().collect(Collectors.toList());
    }
}
