package com.example.colton.habittracker;

import java.util.Date;

/**
 * Created by colton on 2016-09-23.
 */

public class Habit implements HabitInterface{
    private String message;
    private Integer completedCount;
    private Date dateCreated;

    public Habit(String text) {
        setMessage(text);
        this.completedCount = 0;
        this.dateCreated = new Date();
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
        this.completedCount += 1;
    }

    @Override
    public String toString() {
        return this.message.toString();
    }
}
