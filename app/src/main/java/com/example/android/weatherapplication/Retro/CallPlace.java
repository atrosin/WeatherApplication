package com.example.android.weatherapplication.Retro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallPlace {
    @GET("forecast?")
    public Call<SumResponse> getData(@Query("q")String city, @Query("appid")String key,@Query("units")String respFormat);
}
