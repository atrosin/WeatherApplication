package com.example.android.weatherapplication;

import com.google.gson.annotations.SerializedName;

public class ObjMain {
    public class Temp{
        Double temp;
        Double min_temp;
        Double max_temp;
    }
    public class WeatherDescr{
        String general;
        String icon;
    }
    @SerializedName("main")
    private Temp temp;

   // @SerializedName("weather") its list
    private WeatherDescr description;

    public WeatherDescr getDescription() {
        return description;
    }

    public String getTemp() {
        return String.valueOf(temp.temp);
    }

    public String getMin_temp() {
        return String.valueOf(temp.min_temp);
    }

    public String getMax_temp() {
        return String.valueOf(temp.max_temp);
    }
}
