package com.example.android.weatherapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SumResponse {

    @SerializedName("list")
    private List<ObjMain> list;


        public List<ObjMain> getList() {
            return this.list;
        }


}
