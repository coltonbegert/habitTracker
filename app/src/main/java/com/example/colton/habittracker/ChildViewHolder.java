package com.example.colton.habittracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by colton on 2016-10-02.
 */

public class ChildViewHolder extends RecyclerView.ViewHolder {
    private TextView dateTextView;
    public ChildViewHolder(View itemView) {
        super(itemView);
        dateTextView = (TextView) itemView.findViewById(R.id.childTextView);
    }

    public TextView getDateTextView() {
        return dateTextView;
    }
}
