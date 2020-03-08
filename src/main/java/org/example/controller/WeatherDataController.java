package org.example.controller;

import org.example.data.observerPatern.observer.impl.CurrentConditionsDisplay;
import org.example.data.observerPatern.observer.impl.TemperatureStatisticDisplay;
import org.example.data.observerPatern.subject.impl.WeatherData;
import org.example.helper.JsonHelper;
import org.example.view.WeatherDataView;
import org.json.JSONObject;

public class WeatherDataController {

     private WeatherData weatherData;
     private WeatherDataView weatherDataView;


    public WeatherDataController() {
        weatherData = new WeatherData();
        weatherDataView = new WeatherDataView();
    }

    public void launch(){
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        TemperatureStatisticDisplay temperatureStatisticDisplay = new TemperatureStatisticDisplay(weatherData);
        JsonHelper jsonHelper = new JsonHelper();
        weatherDataView.separateOutput();
        weatherData.setMeasurements(jsonHelper.getWeatherParameters());
        weatherDataView.separateOutput();
        /*weatherData.setMeasurements(20, 75, 20);
        weatherDataView.separateOutput();*/
    }
}
