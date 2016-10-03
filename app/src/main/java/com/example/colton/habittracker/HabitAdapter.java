package com.example.colton.habittracker;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.ArrayList;

/**
 * Created by colton on 2016-09-24.
 */

//This was created based upon the tutorial https://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView
    // This code is open source.

public class HabitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private HabitManager habitManager;
//    private ArrayList<Habit> habitList;
    private ArrayList<String> repeatList;
    private RecyclerView statisticRecyclerView;
    private RecyclerView dayRecyclerView;
    private DayToggleAdapter dayToggleAdapter;
    private StatisticViewAdapter statisticViewAdapter;

    public HabitAdapter(HabitManager habitmanager) {
//        super(context, resource);
//        this.habitList = hList;
        this.habitManager = habitmanager;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        viewHolder = new HabitViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final HabitViewHolder viewHolder = (HabitViewHolder) holder;

//        ArrayList<String> completionArray = habitList.get(position).getCompletionDates();
//        ArrayAdapter<String> completionDateArrayAdapter = new ArrayAdapter<String>((Activity)this, android.R.layout.simple_list_item_1, completionArray);
//        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(holder)
//        ListView
//        viewHolder.getCompletionListView()

        final ArrayList<Habit> habitList = habitManager.getHabits();

        statisticRecyclerView = (RecyclerView) viewHolder.getStatisticRecyclerView();
//        statisticViewAdapter = new StatisticViewAdapter(habitManager.getHabitCompletionList(habitList.get(position)));
        statisticViewAdapter = new StatisticViewAdapter(habitList.get(position));
        statisticRecyclerView.setAdapter(statisticViewAdapter);
        LinearLayoutManager layout = new LinearLayoutManager(viewHolder.getStatisticView().getContext(),LinearLayoutManager.VERTICAL,false);
        layout.setAutoMeasureEnabled(true);
        statisticRecyclerView.setLayoutManager(layout);

//        repeatList = new ArrayList<>();
        dayRecyclerView = (RecyclerView) viewHolder.getDayRecyclerView();

        dayToggleAdapter = new DayToggleAdapter(habitManager.getHabitDateManager(habitList.get(position)));
        dayRecyclerView.setAdapter(dayToggleAdapter);
        LinearLayoutManager dayLayout = new LinearLayoutManager(viewHolder.getDayFrameLayout().getContext(), LinearLayoutManager.HORIZONTAL,false);
        dayLayout.setAutoMeasureEnabled(true);
        dayRecyclerView.setLayoutManager(dayLayout);



        viewHolder.getHabitMessage().setText(habitManager.getHabitText(habitList.get(position)));
        viewHolder.getCompletedNumber().setText(habitManager.getCompletedCount(habitList.get(position)));
//                habitList.get(position).getCompletedCount().toString());
        viewHolder.getHabitCompleteButton().setText("complete");


//        http://stackoverflow.com/questions/29698436/how-to-handle-multiple-layout-clicks-in-recyclerview-in-android
//        used to find the proper way of implemeting onclicklisteners in recyclerviews
        viewHolder.getDeleteButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.getStatisticToggle().setChecked(false);
//                habitList.remove(position);

                habitManager.deleteHabit(habitList.get(position));
                notifyDataSetChanged();
                statisticViewAdapter.notifyDataSetChanged();
            }
        });
        viewHolder.getHabitCompleteButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                habitManager.completeHabit(habitList.get(position));
                notifyDataSetChanged();
                statisticViewAdapter.notifyDataSetChanged();
                viewHolder.getCompletedImageView().setVisibility(View.VISIBLE);

//                statisticViewAdapter.notifyAll();
            }
        });


//        viewHolder.getStatisticToggle().setBackground(new VectorDrawable(R.drawable.ic_expand_more_black_24dp));
        viewHolder.getStatisticToggle().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    viewHolder.getStatisticView().setVisibility(View.VISIBLE);
                } else {
                    viewHolder.getStatisticView().setVisibility(View.GONE);
                }
            }
        });
//        viewHolder.getStatisticToggle().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.getStatisticView().setVisibility(viewHolder.getStatisticToggle().);
//            }
//        });




    }

//
    @Override
    public int getItemCount() {
        return this.habitManager.getHabits().size();
    }

}
