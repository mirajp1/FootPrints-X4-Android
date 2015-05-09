package com.techo.fpx4;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

public class ScheduleInfo extends SherlockActivity {


    ArrayList<String> info;

    String data = "";
    EditText event_id;
    String event_id_text;
    TextView button;


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_schedule_info);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final String actionBarTitle = getIntent().getExtras().getString("actionBarTitle");
        setTitle(actionBarTitle);

        event_id = (EditText) findViewById(R.id.enter_et);
        button = (TextView) findViewById(R.id.button);

        final TableLayout schedule_info = (TableLayout) findViewById(R.id.schedule_info);

        final TextView event_name = (TextView) findViewById(R.id.event_name);

        final TextView dayh_1 = (TextView) findViewById(R.id.dayh_1);
        final TextView dayh_2 = (TextView) findViewById(R.id.dayh_2);
        final TextView dayh_3 = (TextView) findViewById(R.id.dayh_3);
        final TextView dayh_4 = (TextView) findViewById(R.id.dayh_4);
        final TextView dayh_5 = (TextView) findViewById(R.id.dayh_5);
        final TextView dayh_6 = (TextView) findViewById(R.id.dayh_6);

        final TableRow place_1_r = (TableRow) findViewById(R.id.place_1_r);
        final TableRow place_2_r = (TableRow) findViewById(R.id.place_2_r);
        final TableRow place_3_r = (TableRow) findViewById(R.id.place_3_r);
        final TableRow place_4_r = (TableRow) findViewById(R.id.place_4_r);
        final TableRow place_5_r = (TableRow) findViewById(R.id.place_5_r);
        final TableRow place_6_r = (TableRow) findViewById(R.id.place_6_r);

        final TextView place_1_t = (TextView) findViewById(R.id.place_1_t);
        final TextView place_2_t = (TextView) findViewById(R.id.place_2_t);
        final TextView place_3_t = (TextView) findViewById(R.id.place_3_t);
        final TextView place_4_t = (TextView) findViewById(R.id.place_4_t);
        final TextView place_5_t = (TextView) findViewById(R.id.place_5_t);
        final TextView place_6_t = (TextView) findViewById(R.id.place_6_t);

        final TableRow slot1_1_r = (TableRow) findViewById(R.id.slot1_1_r);
        final TableRow slot1_2_r = (TableRow) findViewById(R.id.slot1_2_r);
        final TableRow slot1_3_r = (TableRow) findViewById(R.id.slot1_3_r);
        final TableRow slot1_4_r = (TableRow) findViewById(R.id.slot1_4_r);
        final TableRow slot1_5_r = (TableRow) findViewById(R.id.slot1_5_r);
        final TableRow slot1_6_r = (TableRow) findViewById(R.id.slot1_6_r);

        final TextView slot1_1_t = (TextView) findViewById(R.id.slot1_1_t);
        final TextView slot1_2_t = (TextView) findViewById(R.id.slot1_2_t);
        final TextView slot1_3_t = (TextView) findViewById(R.id.slot1_3_t);
        final TextView slot1_4_t = (TextView) findViewById(R.id.slot1_4_t);
        final TextView slot1_5_t = (TextView) findViewById(R.id.slot1_5_t);
        final TextView slot1_6_t = (TextView) findViewById(R.id.slot1_6_t);

        final TableRow slot2_1_r = (TableRow) findViewById(R.id.slot2_1_r);
        final TableRow slot2_2_r = (TableRow) findViewById(R.id.slot2_2_r);
        final TableRow slot2_3_r = (TableRow) findViewById(R.id.slot2_3_r);
        final TableRow slot2_4_r = (TableRow) findViewById(R.id.slot2_4_r);
        final TableRow slot2_5_r = (TableRow) findViewById(R.id.slot2_5_r);
        final TableRow slot2_6_r = (TableRow) findViewById(R.id.slot2_6_r);

        final TextView slot2_1_t = (TextView) findViewById(R.id.slot2_1_t);
        final TextView slot2_2_t = (TextView) findViewById(R.id.slot2_2_t);
        final TextView slot2_3_t = (TextView) findViewById(R.id.slot2_3_t);
        final TextView slot2_4_t = (TextView) findViewById(R.id.slot2_4_t);
        final TextView slot2_5_t = (TextView) findViewById(R.id.slot2_5_t);
        final TextView slot2_6_t = (TextView) findViewById(R.id.slot2_6_t);

        final TableRow slot3_1_r = (TableRow) findViewById(R.id.slot3_1_r);
        final TableRow slot3_2_r = (TableRow) findViewById(R.id.slot3_2_r);
        final TableRow slot3_3_r = (TableRow) findViewById(R.id.slot3_3_r);
        final TableRow slot3_4_r = (TableRow) findViewById(R.id.slot3_4_r);
        final TableRow slot3_5_r = (TableRow) findViewById(R.id.slot3_5_r);
        final TableRow slot3_6_r = (TableRow) findViewById(R.id.slot3_6_r);

        final TextView slot3_1_t = (TextView) findViewById(R.id.slot3_1_t);
        final TextView slot3_2_t = (TextView) findViewById(R.id.slot3_2_t);
        final TextView slot3_3_t = (TextView) findViewById(R.id.slot3_3_t);
        final TextView slot3_4_t = (TextView) findViewById(R.id.slot3_4_t);
        final TextView slot3_5_t = (TextView) findViewById(R.id.slot3_5_t);
        final TextView slot3_6_t = (TextView) findViewById(R.id.slot3_6_t);

        final TableRow slot4_1_r = (TableRow) findViewById(R.id.slot4_1_r);
        final TableRow slot4_2_r = (TableRow) findViewById(R.id.slot4_2_r);
        final TableRow slot4_3_r = (TableRow) findViewById(R.id.slot4_3_r);
        final TableRow slot4_4_r = (TableRow) findViewById(R.id.slot4_4_r);
        final TableRow slot4_5_r = (TableRow) findViewById(R.id.slot4_5_r);
        final TableRow slot4_6_r = (TableRow) findViewById(R.id.slot4_6_r);

        final TextView slot4_1_t = (TextView) findViewById(R.id.slot4_1_t);
        final TextView slot4_2_t = (TextView) findViewById(R.id.slot4_2_t);
        final TextView slot4_3_t = (TextView) findViewById(R.id.slot4_3_t);
        final TextView slot4_4_t = (TextView) findViewById(R.id.slot4_4_t);
        final TextView slot4_5_t = (TextView) findViewById(R.id.slot4_5_t);
        final TextView slot4_6_t = (TextView) findViewById(R.id.slot4_6_t);

        final TableRow slot5_1_r = (TableRow) findViewById(R.id.slot5_1_r);
        final TableRow slot5_2_r = (TableRow) findViewById(R.id.slot5_2_r);
        final TableRow slot5_3_r = (TableRow) findViewById(R.id.slot5_3_r);
        final TableRow slot5_4_r = (TableRow) findViewById(R.id.slot5_4_r);
        final TableRow slot5_5_r = (TableRow) findViewById(R.id.slot5_5_r);
        final TableRow slot5_6_r = (TableRow) findViewById(R.id.slot5_6_r);

        final TextView slot5_1_t = (TextView) findViewById(R.id.slot5_1_t);
        final TextView slot5_2_t = (TextView) findViewById(R.id.slot5_2_t);
        final TextView slot5_3_t = (TextView) findViewById(R.id.slot5_3_t);
        final TextView slot5_4_t = (TextView) findViewById(R.id.slot5_4_t);
        final TextView slot5_5_t = (TextView) findViewById(R.id.slot5_5_t);
        final TextView slot5_6_t = (TextView) findViewById(R.id.slot5_6_t);

        final RelativeLayout schedule_info_l = (RelativeLayout) findViewById(R.id.schedule_info_l);

        getSupportActionBar().setIcon(R.drawable.schedule_w);


        schedule_info.setVisibility(View.INVISIBLE);

        event_name.setVisibility(View.INVISIBLE);

        dayh_1.setVisibility(View.INVISIBLE);
        dayh_2.setVisibility(View.INVISIBLE);
        dayh_3.setVisibility(View.INVISIBLE);
        dayh_4.setVisibility(View.INVISIBLE);
        dayh_5.setVisibility(View.INVISIBLE);
        dayh_6.setVisibility(View.INVISIBLE);

        place_1_r.setVisibility(View.INVISIBLE);
        place_2_r.setVisibility(View.INVISIBLE);
        place_3_r.setVisibility(View.INVISIBLE);
        place_4_r.setVisibility(View.INVISIBLE);
        place_5_r.setVisibility(View.INVISIBLE);
        place_6_r.setVisibility(View.INVISIBLE);

        slot1_1_r.setVisibility(View.INVISIBLE);
        slot1_2_r.setVisibility(View.INVISIBLE);
        slot1_3_r.setVisibility(View.INVISIBLE);
        slot1_4_r.setVisibility(View.INVISIBLE);
        slot1_5_r.setVisibility(View.INVISIBLE);
        slot1_6_r.setVisibility(View.INVISIBLE);

        slot2_1_r.setVisibility(View.INVISIBLE);
        slot2_2_r.setVisibility(View.INVISIBLE);
        slot2_3_r.setVisibility(View.INVISIBLE);
        slot2_4_r.setVisibility(View.INVISIBLE);
        slot2_5_r.setVisibility(View.INVISIBLE);
        slot2_6_r.setVisibility(View.INVISIBLE);

        slot3_1_r.setVisibility(View.INVISIBLE);
        slot3_2_r.setVisibility(View.INVISIBLE);
        slot3_3_r.setVisibility(View.INVISIBLE);
        slot3_4_r.setVisibility(View.INVISIBLE);
        slot3_5_r.setVisibility(View.INVISIBLE);
        slot3_6_r.setVisibility(View.INVISIBLE);

        slot4_1_r.setVisibility(View.INVISIBLE);
        slot4_2_r.setVisibility(View.INVISIBLE);
        slot4_3_r.setVisibility(View.INVISIBLE);
        slot4_4_r.setVisibility(View.INVISIBLE);
        slot4_5_r.setVisibility(View.INVISIBLE);
        slot4_6_r.setVisibility(View.INVISIBLE);

        slot5_1_r.setVisibility(View.INVISIBLE);
        slot5_2_r.setVisibility(View.INVISIBLE);
        slot5_3_r.setVisibility(View.INVISIBLE);
        slot5_4_r.setVisibility(View.INVISIBLE);
        slot5_5_r.setVisibility(View.INVISIBLE);
        slot5_6_r.setVisibility(View.INVISIBLE);


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                event_id_text = event_id.getText().toString().toUpperCase();

                if (!isValidEventId(event_id_text))
                    Toast.makeText(getApplicationContext(), "Please Enter a valid Event-ID",
                            Toast.LENGTH_LONG).show();
                else {

                    if (event_id_text.isEmpty())
                        Toast.makeText(getApplicationContext(), "Please Enter the Event-ID before clicking the button.",
                                Toast.LENGTH_LONG).show();
                    else {

                        final GetScheduleFromDB getdb = new GetScheduleFromDB();
                        new Thread(new Runnable() {
                            public void run() {
                                data = getdb.getSchedule(event_id_text);
                                System.out.println(data);

                                runOnUiThread(new Runnable() {


                                    @Override
                                    public void run() {

                                        if (data.equals("error"))
                                            Toast.makeText(getApplicationContext(), "Internet Connection not found. Please Connect your phone to internet.",
                                                    Toast.LENGTH_LONG).show();
                                        else {

                                            info = parseJSON(data);

                                            if (info.get(0).equals("0")) {

                                                Toast.makeText(getApplicationContext(), "Event-ID not found or Schedule has not been decided yet. Please check your Event-ID or try again later.",
                                                        Toast.LENGTH_LONG).show();
                                                schedule_info.setVisibility(View.INVISIBLE);
                                            } else if (info.get(0).equals("1")) {

                                                Toast.makeText(getApplicationContext(), "Schedule has not yet been decided. Please check later.",
                                                        Toast.LENGTH_LONG).show();

                                                schedule_info.setVisibility(View.INVISIBLE);
                                            } else {

                                                int days = Integer.parseInt(info.get(info.size() - 1));
                                                System.out.println(days);
                                                System.out.println(info.size());

                                                dayh_1.setVisibility(View.GONE);
                                                dayh_2.setVisibility(View.GONE);
                                                dayh_3.setVisibility(View.GONE);
                                                dayh_4.setVisibility(View.GONE);
                                                dayh_5.setVisibility(View.GONE);
                                                dayh_6.setVisibility(View.GONE);

                                                place_1_r.setVisibility(View.GONE);
                                                place_2_r.setVisibility(View.GONE);
                                                place_3_r.setVisibility(View.GONE);
                                                place_4_r.setVisibility(View.GONE);
                                                place_5_r.setVisibility(View.GONE);
                                                place_6_r.setVisibility(View.GONE);

                                                slot1_1_r.setVisibility(View.GONE);
                                                slot1_2_r.setVisibility(View.GONE);
                                                slot1_3_r.setVisibility(View.GONE);
                                                slot1_4_r.setVisibility(View.GONE);
                                                slot1_5_r.setVisibility(View.GONE);
                                                slot1_6_r.setVisibility(View.GONE);

                                                slot2_1_r.setVisibility(View.GONE);
                                                slot2_2_r.setVisibility(View.GONE);
                                                slot2_3_r.setVisibility(View.GONE);
                                                slot2_4_r.setVisibility(View.GONE);
                                                slot2_5_r.setVisibility(View.GONE);
                                                slot2_6_r.setVisibility(View.GONE);

                                                slot3_1_r.setVisibility(View.GONE);
                                                slot3_2_r.setVisibility(View.GONE);
                                                slot3_3_r.setVisibility(View.GONE);
                                                slot3_4_r.setVisibility(View.GONE);
                                                slot3_5_r.setVisibility(View.GONE);
                                                slot3_6_r.setVisibility(View.GONE);

                                                slot4_1_r.setVisibility(View.GONE);
                                                slot4_2_r.setVisibility(View.GONE);
                                                slot4_3_r.setVisibility(View.GONE);
                                                slot4_4_r.setVisibility(View.GONE);
                                                slot4_5_r.setVisibility(View.GONE);
                                                slot4_6_r.setVisibility(View.GONE);

                                                slot5_1_r.setVisibility(View.GONE);
                                                slot5_2_r.setVisibility(View.GONE);
                                                slot5_3_r.setVisibility(View.GONE);
                                                slot5_4_r.setVisibility(View.GONE);
                                                slot5_5_r.setVisibility(View.GONE);
                                                slot5_6_r.setVisibility(View.GONE);

                                                schedule_info.setVisibility(View.VISIBLE);

                                                event_name.setVisibility(View.VISIBLE);
                                                event_name.setText(info.get(0));

                                                if (days > 0) {

                                                    dayh_1.setVisibility(View.VISIBLE);
                                                    dayh_1.setText(info.get(1));


                                                    if (!info.get(2).equals("0")) {
                                                        place_1_r.setVisibility(View.VISIBLE);
                                                        place_1_t.setText(info.get(2));
                                                    }

                                                    if (!info.get(3).equals("0")) {
                                                        slot1_1_r.setVisibility(View.VISIBLE);
                                                        slot1_1_t.setText(info.get(3));
                                                    }

                                                    if (!info.get(4).equals("0")) {
                                                        slot2_1_r.setVisibility(View.VISIBLE);
                                                        slot2_1_t.setText(info.get(4));
                                                    }

                                                    if (!info.get(5).equals("0")) {
                                                        slot3_1_r.setVisibility(View.VISIBLE);
                                                        slot3_1_t.setText(info.get(5));
                                                    }

                                                    if (!info.get(6).equals("0")) {
                                                        slot4_1_r.setVisibility(View.VISIBLE);
                                                        slot4_1_t.setText(info.get(6));
                                                    }

                                                    if (!info.get(7).equals("0")) {
                                                        slot5_1_r.setVisibility(View.VISIBLE);
                                                        slot5_1_t.setText(info.get(7));
                                                    }

                                                }


                                                if (days > 1) {

                                                    dayh_2.setVisibility(View.VISIBLE);
                                                    dayh_2.setText(info.get(10));


                                                    if (!info.get(11).equals("0")) {
                                                        place_2_r.setVisibility(View.VISIBLE);
                                                        place_2_t.setText(info.get(11));
                                                    }

                                                    if (!info.get(12).equals("0")) {
                                                        slot1_2_r.setVisibility(View.VISIBLE);
                                                        slot1_2_t.setText(info.get(12));
                                                    }

                                                    if (!info.get(13).equals("0")) {
                                                        slot2_2_r.setVisibility(View.VISIBLE);
                                                        slot2_2_t.setText(info.get(13));
                                                    }

                                                    if (!info.get(14).equals("0")) {
                                                        slot3_2_r.setVisibility(View.VISIBLE);
                                                        slot3_2_t.setText(info.get(14));
                                                    }

                                                    if (!info.get(15).equals("0")) {
                                                        slot4_2_r.setVisibility(View.VISIBLE);
                                                        slot4_2_t.setText(info.get(15));
                                                    }

                                                    if (!info.get(16).equals("0")) {
                                                        slot5_2_r.setVisibility(View.VISIBLE);
                                                        slot5_2_t.setText(info.get(16));
                                                    }

                                                }


                                                if (days > 2) {

                                                    dayh_3.setVisibility(View.VISIBLE);
                                                    dayh_3.setText(info.get(19));


                                                    if (!info.get(20).equals("0")) {
                                                        place_3_r.setVisibility(View.VISIBLE);
                                                        place_3_t.setText(info.get(20));
                                                    }

                                                    if (!info.get(21).equals("0")) {
                                                        slot1_3_r.setVisibility(View.VISIBLE);
                                                        slot1_3_t.setText(info.get(21));
                                                    }

                                                    if (!info.get(22).equals("0")) {
                                                        slot2_3_r.setVisibility(View.VISIBLE);
                                                        slot2_3_t.setText(info.get(22));
                                                    }

                                                    if (!info.get(23).equals("0")) {
                                                        slot3_3_r.setVisibility(View.VISIBLE);
                                                        slot3_3_t.setText(info.get(23));
                                                    }

                                                    if (!info.get(24).equals("0")) {
                                                        slot4_3_r.setVisibility(View.VISIBLE);
                                                        slot4_3_t.setText(info.get(24));
                                                    }

                                                    if (!info.get(25).equals("0")) {
                                                        slot5_3_r.setVisibility(View.VISIBLE);
                                                        slot5_3_t.setText(info.get(25));
                                                    }

                                                }


                                                if (days > 3) {

                                                    dayh_4.setVisibility(View.VISIBLE);
                                                    dayh_4.setText(info.get(28));


                                                    if (!info.get(29).equals("0")) {
                                                        place_4_r.setVisibility(View.VISIBLE);
                                                        place_4_t.setText(info.get(29));
                                                    }

                                                    if (!info.get(30).equals("0")) {
                                                        slot1_4_r.setVisibility(View.VISIBLE);
                                                        slot1_4_t.setText(info.get(30));
                                                    }

                                                    if (!info.get(31).equals("0")) {
                                                        slot2_4_r.setVisibility(View.VISIBLE);
                                                        slot2_4_t.setText(info.get(31));
                                                    }

                                                    if (!info.get(32).equals("0")) {
                                                        slot3_4_r.setVisibility(View.VISIBLE);
                                                        slot3_4_t.setText(info.get(32));
                                                    }

                                                    if (!info.get(33).equals("0")) {
                                                        slot4_4_r.setVisibility(View.VISIBLE);
                                                        slot4_4_t.setText(info.get(33));
                                                    }

                                                    if (!info.get(34).equals("0")) {
                                                        slot5_4_r.setVisibility(View.VISIBLE);
                                                        slot5_4_t.setText(info.get(34));
                                                    }

                                                }


                                                if (days > 4) {

                                                    dayh_5.setVisibility(View.VISIBLE);
                                                    dayh_5.setText(info.get(37));


                                                    if (!info.get(38).equals("0")) {
                                                        place_5_r.setVisibility(View.VISIBLE);
                                                        place_5_t.setText(info.get(38));
                                                    }

                                                    if (!info.get(39).equals("0")) {
                                                        slot1_5_r.setVisibility(View.VISIBLE);
                                                        slot1_5_t.setText(info.get(39));
                                                    }

                                                    if (!info.get(40).equals("0")) {
                                                        slot2_5_r.setVisibility(View.VISIBLE);
                                                        slot2_5_t.setText(info.get(40));
                                                    }

                                                    if (!info.get(41).equals("0")) {
                                                        slot3_5_r.setVisibility(View.VISIBLE);
                                                        slot3_5_t.setText(info.get(41));
                                                    }

                                                    if (!info.get(42).equals("0")) {
                                                        slot4_5_r.setVisibility(View.VISIBLE);
                                                        slot4_5_t.setText(info.get(42));
                                                    }

                                                    if (!info.get(43).equals("0")) {
                                                        slot5_5_r.setVisibility(View.VISIBLE);
                                                        slot5_5_t.setText(info.get(43));
                                                    }

                                                }

                                                if (days > 5) {

                                                    dayh_6.setVisibility(View.VISIBLE);
                                                    dayh_6.setText(info.get(46));


                                                    if (!info.get(47).equals("0")) {
                                                        place_6_r.setVisibility(View.VISIBLE);
                                                        place_6_t.setText(info.get(47));
                                                    }

                                                    if (!info.get(48).equals("0")) {
                                                        slot1_6_r.setVisibility(View.VISIBLE);
                                                        slot1_6_t.setText(info.get(48));
                                                    }

                                                    if (!info.get(49).equals("0")) {
                                                        slot2_6_r.setVisibility(View.VISIBLE);
                                                        slot2_6_t.setText(info.get(49));
                                                    }

                                                    if (!info.get(50).equals("0")) {
                                                        slot3_6_r.setVisibility(View.VISIBLE);
                                                        slot3_6_t.setText(info.get(50));
                                                    }

                                                    if (!info.get(51).equals("0")) {
                                                        slot4_6_r.setVisibility(View.VISIBLE);
                                                        slot4_6_t.setText(info.get(51));
                                                    }

                                                    if (!info.get(52).equals("0")) {
                                                        slot5_6_r.setVisibility(View.VISIBLE);
                                                        slot5_6_t.setText(info.get(52));
                                                    }

                                                }

                                                // Toast.makeText(getApplicationContext(), info.get(0) + "\n" + info.get(1) + "\n"+ info.get(2) + "\n"+ info.get(3) + "\n"+ info.get(4) + "\n"+ info.get(5) + "\n"+ info.get(6) + "\n"+ info.get(7) + "\n"+ info.get(8)+"\n"+info.size(),
                                                //  		  Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }
                                });

                            }
                        }).start();

                    }
                }
            }
        });

    }


    public ArrayList<String> parseJSON(String result) {
        ArrayList<String> info = new ArrayList<String>();
        try {

            JSONObject info_json = new JSONObject(result);

            int days = Integer.parseInt(info_json.getString("noofdays"));


            if (info_json.getString("noofdays").equals("0"))
                info.add(info_json.getString("noofdays"));

            else if (info_json.getString("token").equals("1"))
                info.add(info_json.getString("token"));

            else {

                info.add(info_json.getString("2"));
                info.add(info_json.getString("3"));
                info.add(info_json.getString("4"));
                info.add(info_json.getString("5"));
                info.add(info_json.getString("6"));
                info.add(info_json.getString("7"));
                info.add(info_json.getString("8"));
                info.add(info_json.getString("9"));
                info.add(info_json.getString("10"));


                if (days > 1) {
                    info.add(info_json.getString("13"));
                    info.add(info_json.getString("14"));
                    info.add(info_json.getString("15"));
                    info.add(info_json.getString("16"));
                    info.add(info_json.getString("17"));
                    info.add(info_json.getString("18"));
                    info.add(info_json.getString("19"));
                    info.add(info_json.getString("20"));
                    info.add(info_json.getString("21"));
                }


                if (days > 2) {
                    info.add(info_json.getString("24"));
                    info.add(info_json.getString("25"));
                    info.add(info_json.getString("26"));
                    info.add(info_json.getString("27"));
                    info.add(info_json.getString("28"));
                    info.add(info_json.getString("29"));
                    info.add(info_json.getString("30"));
                    info.add(info_json.getString("31"));
                    info.add(info_json.getString("32"));
                }


                if (days > 3) {
                    info.add(info_json.getString("34"));
                    info.add(info_json.getString("35"));
                    info.add(info_json.getString("36"));
                    info.add(info_json.getString("37"));
                    info.add(info_json.getString("38"));
                    info.add(info_json.getString("39"));
                    info.add(info_json.getString("40"));
                    info.add(info_json.getString("41"));
                    info.add(info_json.getString("42"));
                }


                if (days > 4) {
                    info.add(info_json.getString("47"));
                    info.add(info_json.getString("48"));
                    info.add(info_json.getString("49"));
                    info.add(info_json.getString("50"));
                    info.add(info_json.getString("51"));
                    info.add(info_json.getString("52"));
                    info.add(info_json.getString("53"));
                    info.add(info_json.getString("54"));
                    info.add(info_json.getString("55"));
                }


                if (days > 5) {
                    info.add(info_json.getString("61"));
                    info.add(info_json.getString("62"));
                    info.add(info_json.getString("63"));
                    info.add(info_json.getString("64"));
                    info.add(info_json.getString("65"));
                    info.add(info_json.getString("66"));
                    info.add(info_json.getString("67"));
                    info.add(info_json.getString("68"));
                    info.add(info_json.getString("69"));
                }


                info.add(info_json.getString("noofdays"));

            }

        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return info;
    }


    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    public boolean isValidEventId(String event_id) {

        if (event_id.matches("[A-Z][A-Z]-[0-9][0-9][0-9][0-9]"))
            return true;
        else
            return false;
    }

}