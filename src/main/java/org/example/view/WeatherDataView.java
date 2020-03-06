package org.example.view;

public class WeatherDataView {

    private String separator = "-------------------------------------------";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void separateOutput(){
        System.out.println(separator);
    }
}