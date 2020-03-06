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
    private List<Float> temperatureList;
    private WeatherData weatherData;
    Observable observable;

    public TemperatureStatisticDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
        temperatureList = new ArrayList<>();
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
            updateStatistic();
            display();
        }
    }

    public void updateStatistic(){
        temperatureList.add(temperature);
        if(temperatureList.size()==1){
            minTemperature = temperature;
        }
        averageTemperature = updateAverageTemperature();
        maxTemperature = updateMaxTemperature();
        minTemperature = updateMinTemperature();
    }

    public float updateAverageTemperature(){
        float sum = 0;
        for(Float temperature : temperatureList)
            sum = sum + temperature;
        return sum/temperatureList.size();
    }

    public float updateMaxTemperature(){
        float maxTemperature = this.maxTemperature;
        for(Float temperature : temperatureList){
            if(temperature > maxTemperature)
                maxTemperature = temperature;
        }
        return maxTemperature;
    }

    public float updateMinTemperature(){
        float minTemperature = this.minTemperature;
        for(Float temperature : temperatureList){
            if(temperature < minTemperature)
                minTemperature = temperature;
        }
        return minTemperature;
    }

    @Override
    public String toString() {
        return " - Avg/Max/Min temperature : "
                + averageTemperature + "/"
                + maxTemperature + "/"
                + minTemperature;
    }


}
