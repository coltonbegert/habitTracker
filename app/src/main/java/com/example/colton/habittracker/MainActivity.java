package com.example.colton.habittracker;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

//test of github
public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "savedHabits22745679.sav";
//    private ArrayList<Habit> habitList = new ArrayList<>();
    private  ArrayList<Habit> habitList;
    private HabitAdapter adapter;
    private EditText habitText;
    private RecyclerView habitRecyclerView;
    private HabitManager habitManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        habitManager = new HabitManager();
//
        loadFromFile();
//        habitManager.setHabitList(loadedhabitlist);
//        habitManager = new HabitManager(new ArrayList<Habit>());
        habitManager = new HabitManager(habitList);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button okButton = (Button) findViewById(R.id.button);
        setSupportActionBar(toolbar);
        habitText = (EditText) findViewById(R.id.enterHabit);

        habitRecyclerView = (RecyclerView) findViewById(R.id.habitRecyclerView);
        adapter = new HabitAdapter(habitManager);
        habitRecyclerView.setAdapter(adapter);
        habitRecyclerView.setLayoutManager(new LinearLayoutManager(this));




        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Title");
        alert.setMessage("Message");

// Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                habitManager.addHabit(new Habit(input.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });


//        alert.show();

//        alert.show();

        final Context mContext = this;


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = habitText.getText().toString();
                if (!text.isEmpty()) {
                    Habit newHabit = new Habit(text);
//                    newHabit.Complete();
                    habitManager.addHabit(newHabit);
//                    habitList.add(newHabit);
//                habitList.add(text);
                    adapter.notifyDataSetChanged();
                }

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                habitManager.newHabit();
                EditTextPopup editText = new EditTextPopup(habitManager.newHabit(), mContext);
//                alert.show();
//                habitManager.newHabit(new Habit(newHabitString));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

//        adapter = new ArrayAdapter<Habit>()

    }


    @Override
    protected void onPause() {
        super.onPause();
        saveInFile();
//        SerializableManager.saveSerializable(this,HabitManager,FILENAME);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    http://stackoverflow.com/questions/14981233/android-arraylist-of-custom-objects-save-to-sharedpreferences-serializable
//    implementation of the sharedpreferences was pulled from stack overflow to replaces to code from lonely twitter
//    this change was made because using DateFormate was causing stabilizability errors
    private void loadFromFile() {

        SharedPreferences appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        Gson gson = new Gson();
        String json = appSharedPrefs.getString("MyObject", "");
        Type tokenType  = new TypeToken<ArrayList<Habit>>(){}.getType();
        if(!json.isEmpty()) {
            habitList = gson.fromJson(json, tokenType);
        } else habitList = new ArrayList<>();
    }

    private void saveInFile() {
        ArrayList<Habit> habitList = habitManager.getHabitList();
        SharedPreferences appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
//        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(habitList);
        prefsEditor.putString("MyObject", json);
        prefsEditor.apply();
    }


}
