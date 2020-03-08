package org.example.data.observerPatern.observer.impl;

import org.example.data.observerPatern.observer.abstr.DisplayElements;
import org.example.data.observerPatern.observer.abstr.MyObserver;
import org.example.data.observerPatern.subject.impl.WeatherData;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TemperatureStatisticDisplay implements Observer, DisplayElements {

    private float temperature;
    private float averageTemperature;
    private float maxTemperature;
    private float minTemperature;
    Observable observable;

    public TemperatureStatisticDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData)observable;
            this.temperature = weatherData.getTemperature();
            this.minTemperature = weatherData.getTemp_min();
            this.maxTemperature = weatherData.getTemp_max();
            this.averageTemperature = (maxTemperature + minTemperature) / 2;
            display();
        }
    }

    @Override
    public String toString() {
        return " - Temperature data during the day : "
                + "\n\tAverage : " + averageTemperature
                + "\n\tMaximal : " + maxTemperature
                + "\n\tMinimal : " + minTemperature;
    }


}
