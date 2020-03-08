package org.example;

import org.example.controller.WeatherDataController;
import org.example.helper.JsonHelper;

public class WeatherObserverApp
{
    public static void main( String[] args )
    {
        WeatherDataController weatherDataController = new WeatherDataController();
        weatherDataController.launch();
    }
}
