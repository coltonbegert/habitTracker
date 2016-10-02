package com.example.colton.habittracker;

import android.content.Context;
import android.graphics.drawable.VectorDrawable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final HabitViewHolder viewHolder = (HabitViewHolder) holder;
        viewHolder.getHabitMessage().setText(habitList.get(position).getMessage());
        viewHolder.getCompletedNumber().setText(habitList.get(position).getCompletedCount().toString());
        viewHolder.getHabitCompleteButton().setText("complete");


//        http://stackoverflow.com/questions/29698436/how-to-handle-multiple-layout-clicks-in-recyclerview-in-android
//        used to find the proper way of implemeting onclicklisteners in recyclerviews
        viewHolder.getDeleteButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.getStatisticToggle().setChecked(false);
                habitList.remove(position);
                notifyDataSetChanged();
            }
        });
        viewHolder.getHabitCompleteButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                habitList.get(position).Complete();
                notifyDataSetChanged();
            }
        });


//        viewHolder.getStatisticToggle().setBackground(new VectorDrawable(R.drawable.ic_expand_more_black_24dp));
        viewHolder.getStatisticToggle().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    viewHolder.getStatisticView().setVisibility(View.VISIBLE);
                } else {
                    viewHolder.getStatisticView().setVisibility(View.GONE);
                }
            }
        });
//        viewHolder.getStatisticToggle().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.getStatisticView().setVisibility(viewHolder.getStatisticToggle().);
//            }
//        });




    }

//
    @Override
    public int getItemCount() {
        return this.habitList.size();
    }

}
