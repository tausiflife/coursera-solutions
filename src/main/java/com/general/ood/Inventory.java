package com.general.ood;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        guitars = new ArrayList<>();
    }

    public void addGuitar(String serialNumber, double price, String model, Builder builder, Type type, Wood backWood, Wood topWood) {
        guitars.add(new Guitar(serialNumber,price, model, builder, type, backWood, topWood));
    }

    public Guitar getGuitar(String serialNumber) {
        return guitars.stream().filter(e -> e.getSerialNumber().equals(serialNumber)).findAny().get();
    }

    public List<Guitar> search(GuitarSpec spec) {
        return guitars.stream().filter(guitar -> guitar.getSpec().equals(spec)).collect(Collectors.toList());
    }
}
