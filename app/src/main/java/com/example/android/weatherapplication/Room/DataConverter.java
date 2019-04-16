package com.example.android.weatherapplication.Room;

import android.arch.persistence.room.TypeConverter;

import com.example.android.weatherapplication.ObjMain;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {

    @TypeConverter
    public String fromWeatherDescrList(List<ObjMain.WeatherDescr> weatherDescrList){
        if (weatherDescrList == null){
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<ObjMain.WeatherDescr>>(){}.getType();
        String json = gson.toJson(weatherDescrList,type);
        return json;
    }


    @TypeConverter
    public List<ObjMain.WeatherDescr> toWeatherDescrList(String strWeatherDescr){
        if (strWeatherDescr == null){
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<ObjMain.WeatherDescr>>(){}.getType();
        List<ObjMain.WeatherDescr> freshList = gson.fromJson(strWeatherDescr,type);
        return freshList;
    }
}
