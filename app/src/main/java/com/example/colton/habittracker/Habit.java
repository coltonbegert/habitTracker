package com.example.colton.habittracker;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by colton on 2016-09-23.
 */

public class Habit implements HabitInterface{
    private String message;
    private Integer completedCount;
//    private Date dateCreated;
    private ArrayList<String> completionDates;
    private DateManager dateManager;

    public Habit(String text) {
        DateManager dateManager = new DateManager();
        setMessage(text);
        this.completedCount = 0;
//        this.dateCreated = new Date();
        completionDates = new ArrayList<String>();
//        completionDates.add("Monday1");
//        completionDates.add("jsdfkjsdf");
//        notifyAll();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Integer completedCount) {
        this.completedCount = completedCount;
    }

    public void Complete() {
        DateManager testDateManager = new DateManager();

//        String day = dateManager1.fakeDay();
        completionDates.add(testDateManager.CurrentDay());
//        notifyAll();
        this.completedCount += 1;
    }


    public ArrayList<String> getCompletionDates() {
        return completionDates;
    }

    @Override
    public String toString() {
        return this.message.toString();
    }
}
