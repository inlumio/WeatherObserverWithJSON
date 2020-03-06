package org.example.data.observerPatern.subject.impl;

import org.example.data.observerPatern.observer.abstr.Observer;
import org.example.data.observerPatern.subject.abstr.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i>=0)
            observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers)
            observer.update(temperature, humidity, pressure);
    }

    public void measuresChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measuresChanged();
    }
}
