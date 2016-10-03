package com.example.colton.habittracker;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by colton on 2016-09-23.
 */

public class Habit implements HabitInterface{
    private String message;
//    private Integer completedCount;
    private DateManager dateManager;

    public Habit(String text) {
        this.dateManager = new DateManager();
        setMessage(text);
//        this.completedCount = 0;
//        this.dateCreated = new Date();
//        completionDates = new ArrayList<String>();
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
        return dateManager.getCompletionDates().size();
    }

//    public void setCompletedCount(Integer completedCount) {
//        this.completedCount = completedCount;
//    }

    public void complete() {
//        DateManager testDateManager = new DateManager();

//        String day = dateManager1.fakeDay();
//        completionDates.add(testDateManager.CurrentDay());
//        notifyAll();
//        dateManager.addCompletionDate(dateManager.);
        dateManager.addCompletionDate();
//        completionDates.add(dateManager.CurrentDay());
//        this.completedCount += 1;
    }


    public ArrayList<Date> getCompletionDates() {
        return dateManager.getCompletionDates();
    }
    public String getFormattedDate(Date date){
        return dateManager.getFormattedDate(date);
    }
    public void removeCompletionDate(Date date){
        dateManager.removeCompletionDate(date);
    }

//    public void removeCompletion(String completion){
//        dateManager.
//    }
//    public

    public DateManager getDateManager() {
        return dateManager;
    }

    @Override
    public String toString() {
        return this.message.toString();
    }
}
