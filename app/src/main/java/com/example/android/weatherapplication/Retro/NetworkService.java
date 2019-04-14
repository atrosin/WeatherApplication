package com.example.android.weatherapplication.Retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService singleInst;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private final static String KEY ="a4957aaded07f32de759ac6ddc1e610b";

    public static String getKEY() {
        return KEY;
    }
    private Retrofit retrofit;

    private NetworkService(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public CallPlace getCallPlace(){
        return retrofit.create(CallPlace.class);
    }
    public static NetworkService getSingleInst(){
        if (singleInst==null){
            singleInst= new NetworkService();
        }
        return singleInst;
    }
}
