package com.general.ood.ricksapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private List<Instrument> instruments;

    public Inventory() {
        instruments = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec);
        instruments.add(instrument);
    }

    public Instrument get(String serialNumber) {
        return instruments.stream().filter(e -> e.getSerialNumber().equals(serialNumber)).findAny().get();
    }

    public List<Instrument> search(InstrumentSpec spec) {
        return instruments.stream().filter(guitar -> guitar.getSpec().matches(spec)).collect(Collectors.toList());
    }
}
