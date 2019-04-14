package com.example.android.weatherapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ObjMain {

    public class Temp{
        private  Double temp;
        private  Double temp_min;
        private  Double temp_max;

        public String getTemp() {
            return String.valueOf(temp);
        }

        public String getTemp_min() {

            return String.valueOf(Math.round(temp_min));
        }

        public String getTemp_max() {
            return String.valueOf(Math.round(temp_max));
        }
    }
    public class WeatherDescr{
        private String main;
        public String getMain() {
            return main;
        }
    }

    @SerializedName("dt_txt")
    private String time;

    public String getTime() {
        return time;
    }

    @SerializedName("main")
    private Temp tempInfo;

    public Temp getTempInfo() {
        return tempInfo;
    }

    @SerializedName("weather")
    private List<WeatherDescr> description;

    public List<WeatherDescr> getDescription() {
        return description;
    }


}
