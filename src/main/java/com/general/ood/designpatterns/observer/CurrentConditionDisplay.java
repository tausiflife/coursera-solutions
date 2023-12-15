package com.general.ood.designpatterns.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CurrentConditionDisplay implements Observer, Display{
    private Subject subject;
    private WeatherDataMeasurements measurements;

    public CurrentConditionDisplay(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void display() {
        System.out.println("Current conditions : " + measurements.getTemperature() + " F degrees and " + measurements.getHumidity() + " % humidity");
    }

    @Override
    public void update(WeatherDataMeasurements data) {
        measurements = data;
        display();
    }
}
