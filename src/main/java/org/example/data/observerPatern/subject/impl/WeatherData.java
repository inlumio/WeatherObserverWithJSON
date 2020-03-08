package org.example.data.observerPatern.subject.impl;

import org.example.data.observerPatern.observer.abstr.MyObserver;
import org.example.data.observerPatern.subject.abstr.Subject;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {

    private float temperature;
    private float temp_min;
    private float temp_max;
    private float humidity;
    private float pressure;

    public WeatherData() {  }

    public void measuresChanged(){
        super.setChanged();
        super.notifyObservers();
    }

    public void setMeasurements(JSONObject weatherParameters){
        this.temperature = weatherParameters.getFloat("temp") - 273;
        this.temp_max = weatherParameters.getFloat("temp_max") - 273;
        this.temp_min = weatherParameters.getFloat("temp_min") - 273;
        this.humidity = weatherParameters.getFloat("humidity");
        this.pressure = weatherParameters.getFloat("pressure");
        measuresChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
