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

    public InputHelper(ResourceBundle bundle){
        view = new WeatherDataView();
        this.bundle = bundle;
        citiesCustom = CitiesCustom.citiesData();
    }

    public List<String> selectCity(){
        int count = 0;
        while(true) {
            if (count == 5){
                view.printlnMessage(bundle.getString("muchAttempt"));
                System.exit(0);
            }
            view.printlnMessage(bundle.getString("selectCities"));
            for (Map.Entry<Integer, List<String>> city : citiesCustom.entrySet())
                System.out.println(city.getKey() + " - " + city.getValue().get(0));
            view.printMessage(bundle.getString("selectedCityByUser"));
            int input = checkInput();
            if(citiesCustom.containsKey(input))
                return citiesCustom.get(input);
            else {
                view.printlnMessage(bundle.getString("wrongInput"));
                count++;
            }
        }
    }

    public int checkInput(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
                String input = bufferedReader.readLine();
                return Integer.parseInt(input);
            } catch (IOException e) {
                view.printlnMessage(bundle.getString("wrongInput"));
            }
            catch (NumberFormatException e){
                view.printlnMessage(bundle.getString("wrongInput"));
            }
        }
    }
}
