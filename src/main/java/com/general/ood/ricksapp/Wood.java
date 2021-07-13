package com.general.ood.ricksapp;

public enum Wood {
    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDER, ALDER, SPRUCE, ADIRON_DACK;
    @Override
    public String toString() {
        switch (this) {
            case INDIAN_ROSEWOOD:
                return "Indian Rosewood";
            case BRAZILIAN_ROSEWOOD:
                return "Brazilian Rosewood";
            case MAHOGANY:
                return "Mahogany";
            case MAPLE:
                return "Maple";
            case COCOBOLO:
                return "Cocobolo";
            case CEDER:
                return "Cedar";
            case ALDER:
                return "Alder";
            case SPRUCE:
                return "Spruce";
            case ADIRON_DACK:
                return "Adirondack";
            default:
                return "";
        }
    }
}
