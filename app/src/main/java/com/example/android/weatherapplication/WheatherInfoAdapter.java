package com.example.android.weatherapplication;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WheatherInfoAdapter extends RecyclerView.Adapter<WheatherInfoAdapter.WheatherViewHolder> {
    private List<ObjMain> recycleItems = new ArrayList<>();

    public void setRecycleItems(Collection<ObjMain> items) {
        recycleItems.addAll(items);
        notifyDataSetChanged();
    }
    public void clearRecycleItems(){
        recycleItems.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WheatherViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recclr_item,viewGroup,false);
        return new WheatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull WheatherViewHolder wheatherViewHolder, int position) {
            wheatherViewHolder.bind(recycleItems.get(position));
    }

    @Override
    public int getItemCount() {
        return recycleItems.size();
    }

    class WheatherViewHolder extends RecyclerView.ViewHolder {
        private TextView dayInfo;
        private  TextView tempInfo;
        private ImageView iconImage;
        public WheatherViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.icon);
            dayInfo = itemView.findViewById(R.id.theDayInfo);
            tempInfo = itemView.findViewById(R.id.tempInfo);

        }
        public void bind(ObjMain response){
            Picasso.get().load("http://openweathermap.org/img/w/"+response.description.get(0).getIcon()+".png")/*.resize(50,50).centerCrop()*/.into(iconImage);
            @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = simpleDateFormat.parse(response.getTime());
                System.out.println(date.toString()+" date1");
                @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEEE", Locale.US);
                String dayOfWeek = simpleDateFormat1.format(date);
                dayInfo.setText(dayOfWeek);
                System.out.println(dayOfWeek);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tempInfo.setText(/*response.getTempInfo().getTemp()*/String.format("%s°C ",String.valueOf(response.getTempInfo().temp)));
        }
    }
}
