package com.techo.fpx4;

import java.util.ArrayList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;

public class MapActivity extends SherlockActivity {

    String icon;

    private ListViewAdapter mAdapter;
    private ArrayList<Integer> leftIcon;
    private ArrayList<String> listDescription;
    private ArrayList<String> event_list;

    private ListView mapListView;


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Show the Up button in the action bar.

        icon = getIntent().getStringExtra("actionBarIcon");
        getSupportActionBar().setIcon(getResources().getIdentifier(icon, "drawable", getPackageName())); //set title bar icon

        prepareList();

        mAdapter = new ListViewAdapter(this, event_list, leftIcon, listDescription);

        mapListView = (ListView) findViewById(R.id.mapListView);
        mapListView.setAdapter(mAdapter);


        mapListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                //String itemValue=(String)listview.getItemAtPosition(position);

                switch (itemPosition) {
                    case 0:
                        Intent intent0 = new Intent(MapActivity.this, StnToClg.class);
                        intent0.putExtra("actionBarTitle", event_list.get(0));
                        //intent0.putExtra("department",actionBarTitle);
                        startActivity(intent0);
                        break;


                    case 1:
                        Intent intent1 = new Intent(MapActivity.this, BusToClg.class);
                        intent1.putExtra("actionBarTitle", event_list.get(1));
                        //intent1.putExtra("department",actionBarTitle);
                        startActivity(intent1);
                        break;


                    case 2:
                        Intent intent2 = new Intent(MapActivity.this, CollegeMap.class);
                        intent2.putExtra("actionBarTitle", event_list.get(2));
                        //intent2.putExtra("department",actionBarTitle);
                        startActivity(intent2);
                        break;


                    case 3:
                        Intent intent3 = new Intent(MapActivity.this, AccommoMap.class);
                        intent3.putExtra("actionBarTitle", event_list.get(3));
                        //intent3.putExtra("department",actionBarTitle);
                        startActivity(intent3);
                        break;


                }
            }
        });


    }

    public void prepareList() {

        event_list = new ArrayList<String>();
        listDescription = new ArrayList<String>();
        leftIcon = new ArrayList<Integer>();


        event_list.add("Station to College");
        event_list.add("Bus Depot to College");
        event_list.add("College Map");
        event_list.add("Accommodation");


        listDescription.add("Way to College");
        listDescription.add("Way to College");
        listDescription.add("Overview Map");
        listDescription.add("Way to Accommodation");


        leftIcon.add(R.drawable.map);
        leftIcon.add(R.drawable.map);
        leftIcon.add(R.drawable.map);
        leftIcon.add(R.drawable.map);

    }

}
