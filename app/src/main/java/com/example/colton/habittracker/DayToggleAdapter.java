package com.example.colton.habittracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colton on 2016-10-02.
 */

public class DayToggleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> daysOfWeek;
    private ArrayList<String> repeatDays;

    public DayToggleAdapter(List<String> daysOfWeek, ArrayList<String> repeatDays) {
        this.daysOfWeek = daysOfWeek;
        this.repeatDays = repeatDays;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.day_toggle_buton_layout, parent, false);
        viewHolder = new DayViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final DayViewHolder viewHolder = (DayViewHolder) holder;



        viewHolder.getDayToggleButton().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if (!repeatDays.contains(daysOfWeek.get(position))) {
                        repeatDays.add(daysOfWeek.get(position));
                        notifyDataSetChanged();
                    }
                } else {
                    if (repeatDays.contains(daysOfWeek.get(position))) {
                        repeatDays.remove(daysOfWeek.get(position));
                        notifyDataSetChanged();
                    }

                }
            }
        });

        if (repeatDays.contains(daysOfWeek.get(position))) {
            viewHolder.getDayToggleButton().setChecked(true);
        } else {
            viewHolder.getDayToggleButton().setChecked(false);
        }
        viewHolder.getDayToggleButton().setText(daysOfWeek.get(position).substring(0,3));





    }

    @Override
    public int getItemCount() {
        return this.daysOfWeek.size();
    }
}
