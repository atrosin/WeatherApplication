package com.example.android.weatherapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        public WheatherViewHolder(@NonNull View itemView) {
            super(itemView);
            dayInfo = itemView.findViewById(R.id.theDayInfo);
            tempInfo = itemView.findViewById(R.id.tempInfo);

        }
        public void bind(ObjMain response){
            dayInfo.setText(response.getTime());
            tempInfo.setText(/*response.getTempInfo().getTemp()*/String.format("%s°C ",String.valueOf(response.getTempInfo().getTemp())));
        }
    }
}
