package com.example.colton.habittracker;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by colton on 2016-09-24.
 */

public class EditTextPopup {
//    private Habit habit;

    public EditTextPopup(final Habit habit, Context context) {
//        this.habit = habit;

        AlertDialog.Builder alert = new AlertDialog.Builder(context);

        alert.setTitle("Edit Habit");
        alert.setMessage("Message");

// Set an EditText view to get user input
        final android.widget.EditText input = new android.widget.EditText(context);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                habit.setMessage(input.getText().toString());
                // Do something with value!
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();

    }

}

