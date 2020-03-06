package org.example.data.observerPatern.observer.impl;

import org.example.data.observerPatern.observer.abstr.DisplayElements;
import org.example.data.observerPatern.observer.abstr.Observer;
import org.example.data.observerPatern.subject.impl.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElements {
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public String toString() {
        return "Current Conditions:" +
                "\ntemperature = " + temperature +
                "\nhumidity = " + humidity +
                "\npressure=" + pressure;
    }
}
