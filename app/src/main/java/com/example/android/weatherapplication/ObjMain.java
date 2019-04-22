package com.example.android.weatherapplication;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.example.android.weatherapplication.Room.DataConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class ObjMain {

    public void setId(long id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    public long id;

    public ObjMain() {
    }

    /*public long getId() {
        return id;
    }*/
    public static class Temp{

        /*public Double getTemp() {
            return temp;
        }

        public Double getTemp_min() {
            return temp_min;
        }

        public Double getTemp_max() {
            return temp_max;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public void setTemp_min(Double temp_min) {
            this.temp_min = temp_min;
        }

        public void setTemp_max(Double temp_max) {
            this.temp_max = temp_max;
        }*/

        public  Double temp;
        public  Double temp_min;
        public  Double temp_max;

        public Temp() {
        }
    }

    public static class WeatherDescr{

        public String main = "";

        public String icon;

        public WeatherDescr() {

        }

        public String getIcon() {
            return icon;
        }

        public String getMain() {
            return main;
        }

    }


    @SerializedName("dt_txt")
    public String time;


    public String getTime() {
        return time;
    }

    @Embedded
    @SerializedName("main")
    public Temp tempInfo;

    public Temp getTempInfo() {
        return tempInfo;
    }

    @TypeConverters(DataConverter.class)
    @SerializedName("weather")
    public List<WeatherDescr> description;

    public List<WeatherDescr> getDescription() {
        return description;
    }




}
