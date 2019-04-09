package com.example.android.weatherapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SumResponse {

    @SerializedName("list")
    private ArrayList<TargetObj> list;


        public ArrayList<TargetObj> getList() {
            return this.list;
        }

        public void setList(ArrayList<TargetObj> list) {
            this.list = list;
        }



    public class TargetObj {

        @SerializedName("main")
        Object main;

        public Object getMain() {
            return main;
        }

        public void setMain(Object main) {
            this.main = main;
        }


    }
}
