package com.example.colton.habittracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by colton on 2016-10-01.
 * The purpose of this class is to manage all dates
 * It will compute days until next due, keep track of repeating alarms
 * Every habit will have an instance that allows the habit adapter to know which how to sort it
 */

public class DateManager {
    public List<String> daysOfTheWeek;
    private ArrayList<String> repeatDays;
    private Date d;

    public DateManager() {
        daysOfTheWeek = Arrays.asList("Sunday", "Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        repeatDays = new ArrayList<String>();
//        String[] daysOfTheWeek = new String[]{"Sunday", "Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//        days.addall(daysOfTheWeek);
//        days.addAll(daysOfTheWeek);
//        Days day = new Days();

    }

    public void AddRepeatingDay (String day){
        if (!repeatDays.contains(day) && daysOfTheWeek.contains(day)){
            repeatDays.add(day);
        }
    }

    public void RemoveRepeatingDay (String day){
        if (repeatDays.contains(day) && daysOfTheWeek.contains(day)){
            repeatDays.remove(day);
        }
    }

    public ArrayList<String> getRepeatDays() {
        return repeatDays;
    }
//    http://stackoverflow.com/questions/7651221/android-how-to-get-the-current-day-of-the-week-monday-etc-in-the-users-l
    public String CurrentDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        d = new Date();
        String dayOfTheWeek = sdf.format(d);
        return dayOfTheWeek;
    }
    public String fakeDay(){
        return "hello world";
    }
    public void Complete(){

    }
}
