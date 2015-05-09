package com.techo.fpx4;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

public class FSRActivity extends SherlockActivity {

    String deptName, eventName;

    DataBaseHelper dbh;
    String ICON;

    String INFO;

    String INCHR_NUM_1;
    String INCHR_NUM_2;
    String INCHR_NAME_1;
    String INCHR_NAME_2;
    String INCHR_EMAIL_1;
    String INCHR_EMAIL_2;

    TextView info_i;

    TextView inchr_name_1;
    TextView inchr_num_1;
    TextView inchr_email_1;

    TextView inchr_name_2;
    TextView inchr_num_2;
    TextView inchr_email_2;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fsr);

        if (savedInstanceState != null) {
            this.INFO = savedInstanceState.getString("info");

            this.INCHR_NAME_1 = savedInstanceState.getString("inchr_name_1");
            this.INCHR_NUM_1 = savedInstanceState.getString("inchr_num_1");

            this.INCHR_NAME_2 = savedInstanceState.getString("inchr_name_2");
            this.INCHR_NUM_2 = savedInstanceState.getString("inchr_num_2");

        } else {

            Intent intent = getIntent();
            ICON = intent.getStringExtra("actionBarIcon");
            // deptName.toUpperCase(); //to change it into TABLE NAME

            String actionBarTitle = intent.getStringExtra("actionBarTitle");
            setTitle("FootPrints Social Responsibility"); //Sets the title in ActionBar
            eventName = actionBarTitle;
            deptName = actionBarTitle;

            getSupportActionBar().setIcon(getResources().getIdentifier(ICON, "drawable", getPackageName()));

            info_i = (TextView) findViewById(R.id.info_i);

            inchr_name_1 = (TextView) findViewById(R.id.inchr_name_text_1);
            inchr_num_1 = (TextView) findViewById(R.id.inchr_num_text_1);
            inchr_email_1 = (TextView) findViewById(R.id.inchr_email_text_1);

            inchr_name_2 = (TextView) findViewById(R.id.inchr_name_text_2);
            inchr_num_2 = (TextView) findViewById(R.id.inchr_num_text_2);
            inchr_email_2 = (TextView) findViewById(R.id.inchr_email_text_2);


            dbh = new DataBaseHelper(this);
            String[] eventNametoDB = {eventName};

            Cursor c = dbh.getAnEvent(eventNametoDB, deptName);
            if ((c.getCount() == 0) || !c.moveToFirst()) {
                throw new SQLException("No Data found ");
            }

            do {

                INFO = c.getString(1);
                INCHR_NAME_1 = c.getString(6);
                INCHR_NUM_1 = c.getString(7);
                INCHR_EMAIL_1 = c.getString(8);
                INCHR_NAME_2 = c.getString(9);
                INCHR_NUM_2 = c.getString(10);
                INCHR_EMAIL_2 = c.getString(11);


            }
            while (c.moveToNext());

            c.close();
            dbh.close();


            inchr_num_1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent call = new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:" + INCHR_NUM_1));
                    startActivity(call);
                }
            });


            inchr_num_2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent call = new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:" + INCHR_NUM_2));
                    startActivity(call);
                }
            });

            inchr_email_1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    try {
                        Intent email_1 = new Intent(Intent.ACTION_VIEW);
                        Uri data = Uri.parse("mailto:" + INCHR_EMAIL_1);
                        email_1.setData(data);
                        startActivity(email_1);
                        //startActivity(Intent.createChooser(email_1,"Send Email Using: "));
                    } catch (ActivityNotFoundException e) {

                        int sdk = android.os.Build.VERSION.SDK_INT;
                        if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            clipboard.setText(INCHR_EMAIL_1);
                            Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                        } else {
                            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", INCHR_EMAIL_1);
                            clipboard.setPrimaryClip(clip);
                            Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                        }

                    }


                }
            });

            inchr_email_2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    try {
                        Intent email_2 = new Intent(Intent.ACTION_VIEW);
                        Uri data = Uri.parse("mailto:" + INCHR_EMAIL_2);
                        email_2.setData(data);
                        startActivity(email_2);
                        //startActivity(Intent.createChooser(email_2,"Send Email Using: "));
                    } catch (ActivityNotFoundException e) {

                        int sdk = android.os.Build.VERSION.SDK_INT;
                        if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            clipboard.setText(INCHR_EMAIL_2);
                            Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                        } else {
                            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", INCHR_EMAIL_2);
                            clipboard.setPrimaryClip(clip);
                            Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

        }
    }

    @Override
    public void onResume() {
        super.onResume();


        info_i.setText(INFO);

        inchr_name_1.setText(INCHR_NAME_1);
        inchr_num_1.setText(INCHR_NUM_1);

        inchr_name_2.setText(INCHR_NAME_2);
        inchr_num_2.setText(INCHR_NUM_2);

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("info", INFO);

        savedInstanceState.putString("inchr_name_1", INCHR_NAME_1);
        savedInstanceState.putString("inchr_num_1", INCHR_NUM_1);

        savedInstanceState.putString("inchr_name_2", INCHR_NAME_2);
        savedInstanceState.putString("inchr_num_2", INCHR_NUM_2);


    }


}
