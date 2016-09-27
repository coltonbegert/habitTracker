package com.example.colton.habittracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by colton on 2016-09-24.
 */

//This was created based upon the tutorial https://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView
    // This code is open source.

public class HabitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Habit> habitList;

    public HabitAdapter(ArrayList<Habit> hList) {
//        super(context, resource);
        this.habitList = hList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        viewHolder = new HabitViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HabitViewHolder viewHolder = (HabitViewHolder) holder;
        viewHolder.getHabitMessage().setText(habitList.get(position).getMessage());


    }


    @Override
    public int getItemCount() {
        return this.habitList.size();
    }
}
