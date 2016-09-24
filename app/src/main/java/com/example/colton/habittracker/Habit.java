package com.example.colton.habittracker;

/**
 * Created by colton on 2016-09-23.
 */

public class Habit implements HabitInterface{
    private String message;

    public Habit(String text) {
        setMessage(text);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
