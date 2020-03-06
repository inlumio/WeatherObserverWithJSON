package org.example.controller;

import org.example.data.observerPatern.observer.impl.CurrentConditionsDisplay;
import org.example.data.observerPatern.subject.impl.WeatherData;
import org.example.view.WeatherDataView;

public class WeatherDataController {

     private WeatherData weatherData;
     private WeatherDataView weatherDataView;

    public WeatherDataController() {
        weatherData = new WeatherData();
        weatherDataView = new WeatherDataView();
    }

    public void launch(){
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherDataView.separateOutput();
        weatherData.setMeasurements(35.5f, 50.7f, 25.4f);
        weatherDataView.separateOutput();
        weatherData.setMeasurements(20, 75, 20);
        weatherDataView.separateOutput();
    }
}
