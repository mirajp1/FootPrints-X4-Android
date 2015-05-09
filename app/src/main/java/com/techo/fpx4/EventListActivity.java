package com.techo.fpx4;

import java.util.ArrayList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;

public class EventListActivity extends SherlockActivity {


    private ListViewAdapter mAdapter;
    private ArrayList<Integer> leftIcon;
    private ArrayList<String> listDescription;
    private ArrayList<String> event_list;


    ListView listView;

    DataBaseHelper dbh;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_eventlist);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //final String[] event_list=getIntent().getExtras().getStringArray("event_list");

        final String actionBarTitle = getIntent().getExtras().getString("actionBarTitle");

        if (actionBarTitle.equals("FSE")) {
            setTitle("Footprints Stock Exchange");
        } else if (actionBarTitle.equals("FSR")) {

            setTitle("Footprints Social Responsibilty");
        } else {
            setTitle(actionBarTitle);
        }

        final String icon = getIntent().getExtras().getString("actionBarIcon");
        getSupportActionBar().setIcon(getResources().getIdentifier(icon, "drawable", getPackageName())); //set title bar icon


        String deptName = actionBarTitle;

        event_list = new ArrayList<String>();
        listDescription = new ArrayList<String>();
        leftIcon = new ArrayList<Integer>();


        dbh = new DataBaseHelper(this);

        Cursor c = dbh.getEventList(deptName);

        if ((c.getCount() == 0) || !c.moveToFirst()) {
            throw new SQLException("No Data found ");
            //Toast.makeText(AnEvent.this," that",10).show();
        }

        do {
            event_list.add(c.getString(1));
            if (deptName.equals("Accommodation"))
                listDescription.add(c.getString(16));
            else
                listDescription.add(c.getString(17));

            leftIcon.add(getResources().getIdentifier(c.getString(0), "drawable", getPackageName()));


        } while (c.moveToNext());


        c.close();
        dbh.close();


        mAdapter = new ListViewAdapter(this, event_list, leftIcon, listDescription);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(mAdapter);

        if (!deptName.equals("Accommodation")) {

            listView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int itemPosition = position;
                    //String itemValue=(String)listview.getItemAtPosition(position);

                    switch (itemPosition) {
                        case 0:
                            Intent intent0 = new Intent(EventListActivity.this, EventActivity.class);
                            intent0.putExtra("actionBarTitle", event_list.get(0));
                            intent0.putExtra("department", actionBarTitle);
                            startActivity(intent0);
                            break;


                        case 1:
                            Intent intent1 = new Intent(EventListActivity.this, EventActivity.class);
                            intent1.putExtra("actionBarTitle", event_list.get(1));
                            intent1.putExtra("department", actionBarTitle);
                            startActivity(intent1);
                            break;


                        case 2:
                            Intent intent2 = new Intent(EventListActivity.this, EventActivity.class);
                            intent2.putExtra("actionBarTitle", event_list.get(2));
                            intent2.putExtra("department", actionBarTitle);
                            startActivity(intent2);
                            break;


                        case 3:
                            Intent intent3 = new Intent(EventListActivity.this, EventActivity.class);
                            intent3.putExtra("actionBarTitle", event_list.get(3));
                            intent3.putExtra("department", actionBarTitle);
                            startActivity(intent3);
                            break;

                        case 4:
                            Intent intent4 = new Intent(EventListActivity.this, EventActivity.class);
                            intent4.putExtra("actionBarTitle", event_list.get(4));
                            intent4.putExtra("department", actionBarTitle);
                            startActivity(intent4);
                            break;

                        case 5:
                            Intent intent5 = new Intent(EventListActivity.this, EventActivity.class);
                            intent5.putExtra("actionBarTitle", event_list.get(5));
                            intent5.putExtra("department", actionBarTitle);
                            startActivity(intent5);
                            break;

                    }
                }
            });

        } else {

            listView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int itemPosition = position;
                    //String itemValue=(String)listview.getItemAtPosition(position);

                    switch (itemPosition) {
                        case 0:
                            Intent intent0 = new Intent(EventListActivity.this, AccommoEvent.class);
                            intent0.putExtra("actionBarTitle", event_list.get(0));
                            intent0.putExtra("department", actionBarTitle);
                            startActivity(intent0);
                            break;


                        case 1:
                            Intent intent1 = new Intent(EventListActivity.this, AccommoEvent.class);
                            intent1.putExtra("actionBarTitle", event_list.get(1));
                            intent1.putExtra("department", actionBarTitle);
                            startActivity(intent1);
                            break;


                        case 2:
                            Intent intent2 = new Intent(EventListActivity.this, AccommoEvent.class);
                            intent2.putExtra("actionBarTitle", event_list.get(2));
                            intent2.putExtra("department", actionBarTitle);
                            startActivity(intent2);
                            break;


                    }
                }
            });

        }


    }

	 /*public void prepareList() {
		    
        event_list=new ArrayList<String>();
       // listDescription=new ArrayList<Integer>();
       // leftIcon=new ArrayList<Integer>();
        
        
       
        event_list.add("Fsdfs");
        event_list.add("fdfsdf");
        event_list.add("dasdasd");
        event_list.add("sdsd");
        
        
        
        /*listDescription.add(R.string.tech_contrap_dept);
        listDescription.add(R.string.tech_contrap_dept);
        listDescription.add(R.string.tech_contrap_dept);
        listDescription.add(R.string.tech_contrap_dept);
        listDescription.add(R.string.tech_contrap_dept);
        
        leftIcon.add(R.drawable.virtuosity1);
        leftIcon.add(R.drawable.virtuosity1);
        leftIcon.add(R.drawable.virtuosity1);
        leftIcon.add(R.drawable.virtuosity1);
       
	 }*/


}


	


