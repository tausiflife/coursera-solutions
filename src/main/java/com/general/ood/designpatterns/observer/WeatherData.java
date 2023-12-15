package com.general.ood.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observerList;
    private WeatherDataMeasurements weatherDataMeasurements;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        observerList.stream().forEach(observer -> observer.update(weatherDataMeasurements));
    }

    public void measurementsChanged() {
        notifyAllObservers();
    }

    public void setMeasurements(WeatherDataMeasurements measurements) {
        weatherDataMeasurements = measurements;
        measurementsChanged();
    }
}
