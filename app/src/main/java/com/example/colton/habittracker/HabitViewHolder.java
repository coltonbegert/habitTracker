package com.example.colton.habittracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by colton on 2016-09-26.
 */

//This was created based upon the tutorial https://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView
// This code is open source.

public class HabitViewHolder extends RecyclerView.ViewHolder {
    private TextView habitMessage;
    private Button habitCompleteButton;

    public HabitViewHolder(View itemView) {
        super(itemView);
        habitCompleteButton = (Button) itemView.findViewById(R.id.habitCompleteButton);
        habitMessage = (TextView) itemView.findViewById(R.id.habitTextView);
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
}
