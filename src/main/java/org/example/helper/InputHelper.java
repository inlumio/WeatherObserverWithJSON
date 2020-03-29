package org.example.helper;

import org.example.data.cities.CitiesCustom;
import org.example.view.WeatherDataView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InputHelper {
    private WeatherDataView view;
    private static ResourceBundle bundle;
    private Map<Integer, List<String> > citiesCustom;
    private static int count;

    public InputHelper(ResourceBundle bundle){
        view = new WeatherDataView();
        this.bundle = bundle;
        citiesCustom = CitiesCustom.citiesData();
    }

    public List<String> selectCity(){
        count = 0;
        view.printlnMessage(bundle.getString("selectCities"));
        for (Map.Entry<Integer, List<String>> city : citiesCustom.entrySet())
            view.printlnMessage(city.getKey() + " - " + city.getValue().get(0));
        while(true) {
            int input = checkInput(bundle.getString("selectedCityByUser"));
            if(citiesCustom.containsKey(input))
                return citiesCustom.get(input);
            else {
                view.printlnMessage(bundle.getString("wrongInput"));
                count++;
            }
        }
    }

    public int checkInput(String message){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            if (count == 5){
                view.printlnMessage(bundle.getString("muchAttempt"));
                System.exit(0);
            }
            view.printMessage(message);
            try {
                String input = bufferedReader.readLine();
                return Integer.parseInt(input);
            } catch (IOException e) {
                view.printlnMessage(bundle.getString("wrongInput"));
            }
            catch (NumberFormatException e){
                view.printlnMessage(bundle.getString("wrongInput"));
            }
            count++;
        }
    }
}
