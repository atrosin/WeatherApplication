package com.example.android.weatherapplication.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.android.weatherapplication.ObjMain;

@Database(entities = {ObjMain.class},version = 1)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract ObjMainDao objMainDao();
}
