package org.example.controller;

import org.example.data.observerPatern.observer.impl.CurrentConditionsDisplay;
import org.example.data.observerPatern.observer.impl.TemperatureStatisticDisplay;
import org.example.data.observerPatern.subject.impl.WeatherData;
import org.example.helper.BundleHelper;
import org.example.helper.InputHelper;
import org.example.helper.JsonHelper;
import org.example.view.WeatherDataView;

import java.util.List;
import java.util.ResourceBundle;

public class WeatherDataController {

     private WeatherData weatherData;
     private WeatherDataView weatherDataView;
     ResourceBundle bundle;


    public WeatherDataController() {
        weatherData = new WeatherData();
        weatherDataView = new WeatherDataView();
        bundle = BundleHelper.getBundle();
    }

    public void launch(){
        InputHelper inputHelper = new InputHelper(bundle);
        List<String> city = inputHelper.selectCity();
        new CurrentConditionsDisplay(weatherData);
        new TemperatureStatisticDisplay(weatherData);
        JsonHelper jsonHelper = new JsonHelper();
        jsonHelper.readJSON(city.get(1));
        weatherDataView.separateOutput();
        weatherDataView.printlnMessage(bundle.getString("weatherInCity") + city.get(0) + ":");
        weatherData.setMeasurements(jsonHelper.getWeatherParameters());
        weatherDataView.separateOutput();
        /*weatherData.setMeasurements(20, 75, 20);
        weatherDataView.separateOutput();*/
    }
}
