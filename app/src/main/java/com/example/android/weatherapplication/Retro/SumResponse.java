package com.example.android.weatherapplication.Retro;

import com.example.android.weatherapplication.ObjMain;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SumResponse {

    @SerializedName("list")
    private List<ObjMain> list;

    public SumResponse() {
    }


    public List<ObjMain> getList() {
            return this.list;
        }


}
