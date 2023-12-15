package com.general.ood.ricksapp;

public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, OLSEN, RYEN, PRS, ANY;

    @Override
    public String toString() {
        switch (this) {
            case FENDER:
                return "fender";
            case MARTIN:
                return "martin";
            case GIBSON:
                return "gibson";
            case COLLINGS:
                return "collings";
            case OLSEN:
                return "olsen";
            case RYEN:
                return "ryen";
            case PRS:
                return "prs";
            case ANY:
                return "any";
            default:
                return "";
        }
    }
}
