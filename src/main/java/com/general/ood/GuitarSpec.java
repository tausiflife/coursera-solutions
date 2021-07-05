package com.general.ood;

import java.util.Objects;

public class GuitarSpec {
    private String model;
    private Builder builder;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    public GuitarSpec(String model, Builder builder, Type type, Wood backWood, Wood topWood) {
        this.model = model;
        this.builder = builder;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getModel() {
        return model;
    }

    public Builder getBuilder() {
        return builder;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuitarSpec that = (GuitarSpec) o;
        return model.equals(that.model) && builder == that.builder && type == that.type && backWood == that.backWood && topWood == that.topWood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, builder, type, backWood, topWood);
    }

    @Override
    public String toString() {
        return "GuitarSpec{" +
                "model='" + model + '\'' +
                ", builder=" + builder +
                ", type=" + type +
                ", backWood=" + backWood +
                ", topWood=" + topWood +
                '}';
    }
}
