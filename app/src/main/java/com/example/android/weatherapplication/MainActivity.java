package com.example.android.weatherapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private WheatherInfoAdapter wheatherInfoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

        NetworkService.getSingleInst()
        .getCallPlace()
        .getData("London",NetworkService.getKEY())
        .enqueue(new Callback<SumResponse>() {
            @Override
            public void onResponse(@NonNull Call<SumResponse> call, @NonNull Response<SumResponse> response) {
                System.out.println(call.request().toString());
                //SumResponse sumResponse = response.body();
                ArrayList<SumResponse.TargetObj> arrayList = new ArrayList<>(response.body().getList());
                wheatherInfoAdapter.setRecycleItems(arrayList);
                System.out.println(arrayList.get(0).main.toString());

            }

            @Override
            public void onFailure(Call<SumResponse> call, Throwable t) {
                Log.e(this.toString(),"What a...? "+call.request().toString()+" "+t);

            }
});
    }
    private RecyclerView recyclerView;
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        wheatherInfoAdapter = new WheatherInfoAdapter();
        recyclerView.setAdapter(wheatherInfoAdapter);
    }
}
