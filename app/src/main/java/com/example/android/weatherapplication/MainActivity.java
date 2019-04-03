package com.example.android.weatherapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkService.getSingleInst()
        .getCallPlace()
        .getData("London",NetworkService.getKEY())
        .enqueue(new Callback<SumResponse>() {
            @Override
            public void onResponse(@NonNull Call<SumResponse> call, @NonNull Response<SumResponse> response) {
                System.out.println(call.request().toString());
                System.out.println(response.message()+"\n");
                //SumResponse sumResponse = response.body();
                ArrayList<SumResponse.TargetObj> arrayList = new ArrayList<>(response.body().getList());
                System.out.println(arrayList.get(0).main.toString());

            }

            @Override
            public void onFailure(Call<SumResponse> call, Throwable t) {
                Log.e(this.toString(),"What a fuck "+call.request().toString()+" "+t);

            }



});

    }
}
