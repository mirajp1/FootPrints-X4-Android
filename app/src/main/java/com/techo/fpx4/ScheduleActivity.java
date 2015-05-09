package com.techo.fpx4;

import java.util.ArrayList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.SherlockActivity;

public class ScheduleActivity extends SherlockActivity {

    private ListViewAdapter mAdapter;
    private ArrayList<Integer> leftIcon;
    private ArrayList<String> listDescription;
    private ArrayList<String> event_list;


    ListView schedule_listView;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_schedule);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final String actionBarTitle = getIntent().getExtras().getString("actionBarTitle");
        setTitle(actionBarTitle);

        final String icon = getIntent().getExtras().getString("actionBarIcon");
        getSupportActionBar().setIcon(getResources().getIdentifier(icon, "drawable", getPackageName()));

        prepareList();


        mAdapter = new ListViewAdapter(this, event_list, leftIcon, listDescription);

        schedule_listView = (ListView) findViewById(R.id.schedule_listview);
        schedule_listView.setAdapter(mAdapter);

        schedule_listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                //String itemValue=(String)listview.getItemAtPosition(position);

                switch (itemPosition) {
                    case 0:
                        Intent intent0 = new Intent(ScheduleActivity.this, GetFpIdActivity.class);
                        intent0.putExtra("actionBarTitle", event_list.get(0));
                        //intent0.putExtra("department",actionBarTitle);
                        startActivity(intent0);
                        break;


                    case 1:
                        Intent intent1 = new Intent(ScheduleActivity.this, ScheduleInfo.class);
                        intent1.putExtra("actionBarTitle", event_list.get(1));
                        //intent1.putExtra("department",actionBarTitle);
                        startActivity(intent1);
                        break;

                }
            }
        });


    }


    public void prepareList() {

        event_list = new ArrayList<String>();
        listDescription = new ArrayList<String>();
        leftIcon = new ArrayList<Integer>();


        event_list.add("Get Your FP-ID");
        event_list.add("Get Your Schedule");


        listDescription.add("Enter your details to get FP-ID");
        listDescription.add("Enter your Event-ID to get your Schedule");


        leftIcon.add(R.drawable.schedule);
        leftIcon.add(R.drawable.schedule);


    }
}
