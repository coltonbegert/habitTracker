package com.example.colton.habittracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

    private static final String FILENAME = "savedHabits.sav";
    private ArrayList<Habit> habitList = new ArrayList<>();
    private HabitAdapter adapter;
    private EditText habitText;
    private RecyclerView habitRecyclerView;
    private HabitManager habitManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button okButton = (Button) findViewById(R.id.button);
        setSupportActionBar(toolbar);
        habitText = (EditText) findViewById(R.id.enterHabit);

        habitRecyclerView = (RecyclerView) findViewById(R.id.habitRecyclerView);
        adapter = new HabitAdapter(habitList);
        habitRecyclerView.setAdapter(adapter);
        habitRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        habitManager = new HabitManager();

        //        loadFromFile();
//        habitManager.setHabitList(loadedhabitlist);






        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = habitText.getText().toString();
                if (!text.isEmpty()) {
                    Habit newHabit = new Habit(text);
//                    newHabit.Complete();
                    habitManager.addHabit(newHabit);
                    habitList.add(newHabit);
//                habitList.add(text);
                    adapter.notifyDataSetChanged();
                }

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    private void loadFromFile() {
//        ArrayList<Habit> habitList = new ArrayList<Habit>();
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //Code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept.22,2016
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();
            habitList = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            habitList = new ArrayList<>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try {

            FileOutputStream fos = openFileOutput(FILENAME,0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(habitList, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}
