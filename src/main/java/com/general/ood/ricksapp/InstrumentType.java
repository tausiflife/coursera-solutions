package com.general.ood.ricksapp;

public enum InstrumentType {
    GUITAR, BANJO, DOBRO, FIDDLE, BASS, MANDOLIN;
    @Override
    public String toString() {
        switch (this) {
            case GUITAR:
                return "Guitar";
            case BANJO:
                return "Banjo";
            case DOBRO:
                return "Dobro";
            case FIDDLE:
                return "Fiddle";
            case BASS:
                return "Bass";
            case MANDOLIN:
                return "Mandolin";
            default:
                return "Unspecified";
        }
    }
}
