package org.example.view;

public class WeatherDataView {

    private String separator = "-------------------------------------------";

    public void printlnMessage(String message){
        System.out.println(message);
    }

    public void printMessage(String message){
        System.out.print(message);
    }

    public void separateOutput(){
        System.out.println(separator);
    }
}