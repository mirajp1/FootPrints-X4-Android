package com.techo.fpx4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class AboutUsActivity extends SherlockActivity {


    DataBaseHelper dbh;
    String ICON;

    String deptName, eventName;

    String ABOUT_US;
    TextView about_us_i;


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_about_us);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (savedInstanceState != null) {
            this.ABOUT_US = savedInstanceState.getString("about_us");


        } else {

            Intent intent = getIntent();
            ICON = intent.getStringExtra("actionBarIcon");

            eventName = "About Us";
            deptName = "ABOUTUS";

            getSupportActionBar().setIcon(getResources().getIdentifier(ICON, "drawable", getPackageName()));

            about_us_i = (TextView) findViewById(R.id.about_us_i);


            dbh = new DataBaseHelper(this);
            String[] eventNametoDB = {eventName};

            Cursor c = dbh.getAnEvent(eventNametoDB, deptName);
            if ((c.getCount() == 0) || !c.moveToFirst()) {
                throw new SQLException("No Data found ");
            }

            do {

                ABOUT_US = c.getString(1);


            }
            while (c.moveToNext());

            c.close();
            dbh.close();

        }

    }

    @Override
    public void onResume() {
        super.onResume();


        about_us_i.setText(ABOUT_US);


    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("about_us", ABOUT_US);


    }


}
