package com.example.colton.habittracker;

/**
 * Created by colton on 2016-09-23.
 */

public class Habit implements HabitInterface{
    private String message;
    private Integer completedCount;

    public Habit(String text) {
        setMessage(text);
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
