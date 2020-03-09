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

    private String mainBodyOfUrl = "http://api.openweathermap.org/data/2.5/weather";
    private String appid = "bad4092dcb7625876d4f8721366d5e9c";

    public JsonHelper(){ }

    public void readJSON(String cityId){
        try{
            StringBuilder stringBuilder = new StringBuilder();
            //"http://api.openweathermap.org/data/2.5/weather?id=703448&APPID=bad4092dcb7625876d4f8721366d5e9c"
            URL url=new URL(mainBodyOfUrl + "?"+ "id=" +cityId + "&" + "APPID=" + appid);
            URLConnection urlcon=url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            String line;
            while((line = bufferedReader.readLine())!= null){
                stringBuilder.append(line);
            }
            JSONObject json = new JSONObject(stringBuilder.toString());
            weatherParameters = json.getJSONObject("main");


        }catch(Exception e){System.out.println(e);}

    }

    public JSONObject getWeatherParameters() {
        return weatherParameters;
    }

}
