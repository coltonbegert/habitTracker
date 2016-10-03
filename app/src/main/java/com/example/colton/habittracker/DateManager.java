package com.example.colton.habittracker;

//import java.text.DateFormat;
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
    private List<String> daysOfTheWeek;
    private ArrayList<String> repeatDays;
    private Date d;
    private ArrayList<Date> completionDates;

    public DateManager() {
        daysOfTheWeek = Arrays.asList("Sunday", "Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        repeatDays = new ArrayList<String>();
        completionDates = new ArrayList<>();


    }

    public List<String> getDaysOfTheWeek() {
        return daysOfTheWeek;
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

    public void Complete(){

    }

    public ArrayList<Date> getCompletionDates() {
        return this.completionDates;

    }
    public String getFormattedDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        return simpleDateFormat.format(date);

    }

    public void setCompletionDates(ArrayList<Date> completionDates) {
        this.completionDates = completionDates;
    }
    public void addCompletionDate(){
        Date date = new Date();
        this.completionDates.add(date);
    }
    public void removeCompletionDate(Date completion){
        this.completionDates.remove(completion);
    }
}
