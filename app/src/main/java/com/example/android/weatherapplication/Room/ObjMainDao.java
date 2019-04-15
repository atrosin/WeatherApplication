package com.example.android.weatherapplication.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.android.weatherapplication.ObjMain;

import java.util.List;

@Dao
public interface ObjMainDao {
    @Query("SELECT * from objmain")
    List<ObjMain> getAll();

    @Query("SELECT * from objmain WHERE id = :id")
    ObjMain getById(long id);

    @Insert
    void insert (ObjMain objMain);

    @Update
    void update (ObjMain objMain);

    @Delete
    void delete (ObjMain objMain);
}
