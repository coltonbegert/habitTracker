package com.example.colton.habittracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by colton on 2016-09-26.
 */

//This was created based upon the tutorial https://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView
// This code is open source.

public class HabitViewHolder extends RecyclerView.ViewHolder {
    private TextView habitMessage;
    private Button habitCompleteButton;
    private Button deleteButton;
    private TextView completedNumber;
    private ToggleButton statisticToggle;
    private RelativeLayout statisticView;

    public HabitViewHolder(View itemView) {
        super(itemView);
        habitCompleteButton = (Button) itemView.findViewById(R.id.habitCompleteButton);
        habitMessage = (TextView) itemView.findViewById(R.id.habitTextView);
        deleteButton = (Button) itemView.findViewById(R.id.deleteButton);
        completedNumber = (TextView) itemView.findViewById(R.id.completedNumber);
        statisticToggle = (ToggleButton) itemView.findViewById(R.id.toggleButton3);
        statisticView = (RelativeLayout) itemView.findViewById(R.id.statisticView);
    }

    public TextView getHabitMessage() {
        return habitMessage;
    }

    public void setHabitMessage(TextView habitMessage) {
        this.habitMessage = habitMessage;
    }

    public Button getHabitCompleteButton() {
        return habitCompleteButton;
    }

    public void setHabitCompleteButton(Button habitCompleteButton) {
        this.habitCompleteButton = habitCompleteButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public TextView getCompletedNumber() {
        return completedNumber;
    }

    public RelativeLayout getStatisticView() {
        return statisticView;
    }

    public ToggleButton getStatisticToggle() {
        return statisticToggle;
    }
}
