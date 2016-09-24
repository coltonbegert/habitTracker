package com.example.colton.habittracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

//test of github
public class MainActivity extends AppCompatActivity {

    private ArrayList<Habit> habitList = new ArrayList<>();
//    private ArrayList<String> habitStringList = new ArrayList<String>();
//    private RecyclerView<Habit> habbitView;
    private ArrayAdapter<Habit> adapter;
    private ListView habitListView;// = (ListView) findViewById(R.id.habitListView);
    private EditText habitText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        habitListView = (ListView) findViewById(R.id.habitListView);
//        EditText editText = new EditText();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button okButton = (Button) findViewById(R.id.button);
        setSupportActionBar(toolbar);
        habitText = (EditText) findViewById(R.id.enterHabit);
        String[] habitStringList ={"test", "test2"};
        adapter = new ArrayAdapter<Habit>(this, R.layout.list_item, habitList);
        habitListView.setAdapter(adapter);




        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = habitText.getText().toString();
                if (!text.isEmpty()) {
                    Habit newHabit = new Habit(text);
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
}
