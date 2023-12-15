package com.general.ood.designpatterns.observer;

public class WeatherDataMeasurements {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
