package com.example.android.weatherapplication;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class ObjMain {
    @PrimaryKey(autoGenerate = true)
    private long id;

    public ObjMain() {
    }

    public long getId() {
        return id;
    }

    public class Temp{

        public Double getTemp() {
            return temp;
        }

        public Double getTemp_min() {
            return temp_min;
        }

        public Double getTemp_max() {
            return temp_max;
        }

        private  Double temp;
        private  Double temp_min;
        private  Double temp_max;

        public Temp() {
        }


    }

    public class WeatherDescr{

        private String main;

        public String getMain() {
            return main;
        }

        public WeatherDescr() {
        }
    }

    public String getTime() {
        return time;
    }

    @SerializedName("dt_txt")
    private String time;


    public Temp getTempInfo() {
        return tempInfo;
    }

    @Embedded
    @SerializedName("main")
    private Temp tempInfo;


    public List<WeatherDescr> getDescription() {
        return description;
    }

    @Embedded
    @SerializedName("weather")
    private List<WeatherDescr> description;




}
