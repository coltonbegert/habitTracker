package com.example.colton.habittracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by colton on 2016-10-02.
 */

public class StatisticViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> completionArray;

    public StatisticViewAdapter(ArrayList<String> completionArray) {
        this.completionArray = completionArray;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.child_layout, parent, false);
        viewHolder = new ChildViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final  ChildViewHolder childViewHolder = (ChildViewHolder) holder;
        childViewHolder.getDateTextView().setText(completionArray.get(position));


    }

    @Override
    public int getItemCount() {
        return this.completionArray.size();
    }
}
