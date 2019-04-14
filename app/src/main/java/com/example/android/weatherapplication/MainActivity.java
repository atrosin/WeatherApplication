package com.example.android.weatherapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.android.weatherapplication.Retro.NetworkService;
import com.example.android.weatherapplication.Retro.SumResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText cityEdit;
    private RecyclerView recyclerView;
    private WheatherInfoAdapter wheatherInfoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        cityEdit = (EditText)findViewById(R.id.edit_city);
        cityEdit.setText("Deli");

    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        wheatherInfoAdapter = new WheatherInfoAdapter();
        recyclerView.setAdapter(wheatherInfoAdapter);
    }

    public void startSearch(View view) {
        NetworkService.getSingleInst()
                .getCallPlace()
                .getData(cityEdit.getText().toString(),NetworkService.getKEY(),"metric")
                .enqueue(new Callback<SumResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<SumResponse> call, @NonNull Response<SumResponse> response) {
                        SumResponse sumResponse = response.body();
                        wheatherInfoAdapter.setRecycleItems(sumResponse.getList());
                        System.out.println(sumResponse.getList().get(0).getTempInfo().getTemp_min());
                    }

                    @Override
                    public void onFailure(Call<SumResponse> call, Throwable t) {
                        Log.e(this.toString(),"What a...? "+t+" "+call.request().toString());

                    }
                });
    }
}
