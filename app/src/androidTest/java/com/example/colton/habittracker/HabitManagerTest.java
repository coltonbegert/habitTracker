package com.example.colton.habittracker;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by colton on 2016-10-02.
 */

public class HabitManagerTest extends ActivityInstrumentationTestCase2 {
    public HabitManagerTest() {
        super(com.example.colton.habittracker.HabitManagerTest.class);
    }

    public void testAddHabit{
        Habit habit = new Habit("test");
        HabitManager habitManager = new HabitManager()
    }
}
