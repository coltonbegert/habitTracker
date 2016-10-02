package com.example.colton.habittracker;

import java.util.ArrayList;

/**
 * Created by colton on 2016-10-01.
 */

public class HabitManager {
    private ArrayList<Habit> habitList;

    public HabitManager() {
        this.habitList = new ArrayList<>();

    }

    public void addHabit(Habit habit){
        if (!habitList.contains(habit)){
            habitList.add(habit);
        }

    }
    public void deleteHait(Habit habit){
        if(habitList.contains(habit)) {
            habitList.remove(habit);
        }
    }
    public void setHabitList(ArrayList<Habit> habitList){
        this.habitList = habitList;
    }




    public  ArrayList getHabits(){
        return this.habitList;
    }

    public void newHabit(Habit newHabit) {
    }

//    private ArrayList HabitSort(ArrayList<Habit> habitList) {
//        //this is where the habit will get sorted into days and by date
//        //the headers for the days will also be added to this list in the correct order.
//    }
}
