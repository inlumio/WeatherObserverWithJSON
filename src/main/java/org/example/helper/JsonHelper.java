package org.example.helper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class JsonHelper {

    private JSONObject weatherParameters;

    public JsonHelper(){
        weatherParameters = readJSON();
    }

    public JSONObject readJSON(){
        try{
            StringBuilder stringBuilder = new StringBuilder();
            URL url=new URL("http://api.openweathermap.org/data/2.5/weather?id=703448&APPID=bad4092dcb7625876d4f8721366d5e9c");
            URLConnection urlcon=url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            String line;
            while((line = bufferedReader.readLine())!= null){
                stringBuilder.append(line);
            }
            JSONObject json = new JSONObject(stringBuilder.toString());
            JSONObject necessaryParam = json.getJSONObject("main");

            return necessaryParam;

        }catch(Exception e){System.out.println(e);}

        return null;

    }

    public JSONObject getWeatherParameters() {
        return weatherParameters;
    }

}
