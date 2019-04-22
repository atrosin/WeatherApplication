package com.example.android.weatherapplication;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.weatherapplication.Retro.NetworkService;
import com.example.android.weatherapplication.Retro.SumResponse;
import com.example.android.weatherapplication.Room.WeatherDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private WeatherDatabase db;
    private Button fButton;
    private EditText cityEdit;
    private RecyclerView recyclerView;
    private WheatherInfoAdapter weatherInfoAdapter;
    List<ObjMain> weatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        db =  Room.databaseBuilder(getApplicationContext(),
                WeatherDatabase.class, "objmain").allowMainThreadQueries().build();
        cityEdit = (EditText)findViewById(R.id.edit_city);
        fButton = findViewById(R.id.find_button);
        fButton.setOnClickListener(this);
        cityEdit.setText("deli");
        onClick(findViewById(R.id.find_button));

    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        weatherInfoAdapter = new WheatherInfoAdapter();
        recyclerView.setAdapter(weatherInfoAdapter);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.find_button:

                    NetworkService.getSingleInst()
                            .getCallPlace()
                            .getData(cityEdit.getText().toString(),NetworkService.getKEY(),"metric")
                            .enqueue(new Callback<SumResponse>() {
                                @Override
                                public void onResponse(@NonNull Call<SumResponse> call, @NonNull Response<SumResponse> response) {
                                    //db.clearAllTables();
                                    SumResponse sumResponse = response.body();
                                    weatherData = sumResponse.getList();

                                    if (response.isSuccessful()) {
                                        weatherInfoAdapter.setRecycleItems(weatherData);
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                for (int i = 0; i < weatherData.size(); i++) {
                                                    weatherData.get(i).setId(i + 1);
                                                    db.objMainDao().insert(weatherData.get(i));
                                                }
                                            }
                                        });

                                    }else {
                                        weatherInfoAdapter.setRecycleItems(db.objMainDao().getAll());
                                    }
                                }

                                @Override
                                public void onFailure(Call<SumResponse> call, Throwable t) {
                                    weatherInfoAdapter.setRecycleItems(db.objMainDao().getAll());
                                    Toast.makeText(getApplicationContext(),"Не удалось обновить данные",Toast.LENGTH_LONG).show();
                                }
                            });
                    initRecyclerView();

            }
    }

}
