package com.general.ood.gsf.unit;


import java.util.*;

public class Unit {

    private String type;
    private int id;
    private String name;
    private List weapons;
    private Map properties;

    public Unit(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProperties(String property, Object value) {
        if (properties == null)
            properties = new HashMap();
        properties.put(property, value);
    }

    public Object getProperty(String property) {
        Object obj;
        try {
            obj = this.properties.get(property);
        } catch (RuntimeException e) {
            throw new NoSuchElementException("No element exists with such name " + property);
        }
        return obj;
    }

    public void addWeapon(Weapon weapon) {
        if (weapons == null)
            weapons = new ArrayList();
        weapons.add(weapon);
    }

    public List getWeapons() {
        return weapons;
    }

    public int getId() {
        return id;
    }
}
