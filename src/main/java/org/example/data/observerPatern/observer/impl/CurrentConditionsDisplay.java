package org.example.data.observerPatern.observer.impl;

import org.example.data.observerPatern.observer.abstr.DisplayElements;
import org.example.data.observerPatern.observer.abstr.MyObserver;
import org.example.data.observerPatern.subject.impl.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElements {
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;
    Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
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
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public String toString() {
        return " - Current Conditions:" +
                "\n\ttemperature = " + temperature +
                "\n\thumidity = " + humidity +
                "\n\tpressure=" + pressure;
    }


}
