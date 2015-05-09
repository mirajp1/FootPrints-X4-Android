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

public class GetFpIdActivity extends SherlockActivity {

    String data = "";
    EditText email_et;
    EditText num_et;
    String email;
    String num;

    TextView button;

    private TextView[] event_id;
    private TextView[] event_name;
    private TableRow[] event_r;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_get_fp_id);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final String actionBarTitle = getIntent().getExtras().getString("actionBarTitle");
        setTitle(actionBarTitle);

        final TextView fp_id = (TextView) findViewById(R.id.fp_id);
        final TextView name_1 = (TextView) findViewById(R.id.name_1);

        final TableLayout details = (TableLayout) findViewById(R.id.details);

        //final TableRow name_r=(TableRow) findViewById(R.id.name_r);

        event_id = new TextView[13];
        event_name = new TextView[13];
        event_r = new TableRow[13];

        event_r[0] = (TableRow) findViewById(R.id.event1_r);
        event_r[1] = (TableRow) findViewById(R.id.event2_r);
        event_r[2] = (TableRow) findViewById(R.id.event3_r);
        event_r[3] = (TableRow) findViewById(R.id.event4_r);
        event_r[4] = (TableRow) findViewById(R.id.event5_r);
        event_r[5] = (TableRow) findViewById(R.id.event6_r);
        event_r[6] = (TableRow) findViewById(R.id.event7_r);
        event_r[7] = (TableRow) findViewById(R.id.event8_r);
        event_r[8] = (TableRow) findViewById(R.id.event9_r);
        event_r[9] = (TableRow) findViewById(R.id.event10_r);
        event_r[10] = (TableRow) findViewById(R.id.event11_r);
        event_r[11] = (TableRow) findViewById(R.id.event12_r);
        event_r[12] = (TableRow) findViewById(R.id.event13_r);

        event_id[0] = (TextView) findViewById(R.id.event_id1);
        event_name[0] = (TextView) findViewById(R.id.event_name1);

        event_id[1] = (TextView) findViewById(R.id.event_id2);
        event_name[1] = (TextView) findViewById(R.id.event_name2);

        event_id[2] = (TextView) findViewById(R.id.event_id3);
        event_name[2] = (TextView) findViewById(R.id.event_name3);

        event_id[3] = (TextView) findViewById(R.id.event_id4);
        event_name[3] = (TextView) findViewById(R.id.event_name4);

        event_id[4] = (TextView) findViewById(R.id.event_id5);
        event_name[4] = (TextView) findViewById(R.id.event_name5);


        event_id[5] = (TextView) findViewById(R.id.event_id6);
        event_name[5] = (TextView) findViewById(R.id.event_name6);

        event_id[6] = (TextView) findViewById(R.id.event_id7);
        event_name[6] = (TextView) findViewById(R.id.event_name7);

        event_id[7] = (TextView) findViewById(R.id.event_id8);
        event_name[7] = (TextView) findViewById(R.id.event_name8);

        event_id[8] = (TextView) findViewById(R.id.event_id9);
        event_name[8] = (TextView) findViewById(R.id.event_name9);

        event_id[9] = (TextView) findViewById(R.id.event_id10);
        event_name[9] = (TextView) findViewById(R.id.event_name10);

        event_id[10] = (TextView) findViewById(R.id.event_id11);
        event_name[10] = (TextView) findViewById(R.id.event_name11);

        event_id[11] = (TextView) findViewById(R.id.event_id12);
        event_name[11] = (TextView) findViewById(R.id.event_name12);

        event_id[12] = (TextView) findViewById(R.id.event_id13);
        event_name[12] = (TextView) findViewById(R.id.event_name13);

        final RelativeLayout fp_id_l = (RelativeLayout) findViewById(R.id.fp_id_l);

        //fp_id.setVisibility(View.INVISIBLE);
        //details.setVisibility(View.INVISIBLE);

        fp_id_l.setVisibility(View.INVISIBLE);
        for (int i = 0; i < 13; i++)
            event_r[i].setVisibility(View.INVISIBLE);


        email_et = (EditText) findViewById(R.id.enter_email_et);
        num_et = (EditText) findViewById(R.id.enter_mob_num_et);

        button = (TextView) findViewById(R.id.button);

        getSupportActionBar().setIcon(R.drawable.schedule_w);


        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                email = email_et.getText().toString();
                num = num_et.getText().toString();

                if (isEmailValid(email)) {

                    if (email.isEmpty() || num.isEmpty())
                        Toast.makeText(getApplicationContext(), num + "Please Enter the email id or phone number before clicking the button.",
                                Toast.LENGTH_LONG).show();

                    else {

                        final GetFpIdFromDB getdb = new GetFpIdFromDB();
                        new Thread(new Runnable() {
                            public void run() {
                                data = getdb.getFpId(email, num);
                                System.out.println(data);


                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        ArrayList<String> info = parseJSON(data);

                                        if (data.equals("error"))
                                            Toast.makeText(getApplicationContext(), "Internet Connection not found. Please Connect your phone to internet.",
                                                    Toast.LENGTH_LONG).show();
                                        else {

                                            if (info.get(0).equals("0")) {
                                                Toast.makeText(getApplicationContext(), "No data found. Please check your email id and phone number.",
                                                        Toast.LENGTH_LONG).show();
                                                //fp_id.setVisibility(View.INVISIBLE);
                                                //details.setVisibility(View.INVISIBLE);
                                                fp_id_l.setVisibility(View.INVISIBLE);
                                                //for(int i=0;i<13;i++)
                                                //	event_r[i].setVisibility(View.GONE);
                                            } else {

                                                fp_id_l.setVisibility(View.INVISIBLE);
                                                for (int i = 0; i < 13; i++)
                                                    event_r[i].setVisibility(View.INVISIBLE);

                                                //fp_id.setVisibility(View.VISIBLE);
                                                //details.setVisibility(View.VISIBLE);

                                                fp_id_l.setVisibility(View.VISIBLE);

                                                int events = Integer.parseInt(info.get(info.size() - 1));
                                                int i = 2;
                                                int j;


                                                fp_id.setText(info.get(0));
                                                name_1.setText(info.get(1) + "  " + info.get(2));

                                                for (j = 0; j < events; j++) {
                                                    event_r[j].setVisibility(View.VISIBLE);
                                                    event_id[j].setText(info.get(++i));
                                                    event_name[j].setText(info.get(++i));
                                                }

			    		                        	/*if(events>12){
			    		     	            		    event_r[++j].setVisibility(View.VISIBLE);
			    		     	            		    event_id[++j].setText(info.get(++i));
			    		     	            		    event_name[++j].setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>11){
			    		     	            		    event12_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id12.setText(info.get(++i));
			    		     	            		    event_name12.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>10){
			    		     	            		    event11_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id11.setText(info.get(++i));
			    		     	            		    event_name11.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>9){
			    		     	            		    event10_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id10.setText(info.get(++i));
			    		     	            		    event_name10.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>8){
			    		     	            		    event9_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id9.setText(info.get(++i));
			    		     	            		    event_name9.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>7){
			    		     	            		    event8_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id8.setText(info.get(++i));
			    		     	            		    event_name8.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>6){
			    		     	            		    event7_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id7.setText(info.get(++i));
			    		     	            		    event_name7.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>5){
			    		     	            		    event6_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id6.setText(info.get(++i));
			    		     	            		    event_name6.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>4){
			    		     	            		    event5_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id5.setText(info.get(++i));
			    		     	            		    event_name5.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>3){
			    		     	            		    event4_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id4.setText(info.get(++i));
			    		     	            		    event_name4.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>2){
			    		     	            		    event3_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id3.setText(info.get(++i));
			    		     	            		    event_name3.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	if(events>1){
			    		     	            		    event2_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id2.setText(info.get(++i));
			    		     	            		    event_name2.setText(info.get(++i));
			    		     	            	    }
			    		                        	
			    		                        	
			    		     	            		    event1_r.setVisibility(View.VISIBLE);
			    		     	            		    event_id1.setText(info.get(++i));
			    		     	            		    event_name1.setText(info.get(++i));
			    		     	            	    
			    		                        	*/

                                            }
                                        }
                                    }
                                });

                            }
                        }).start();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a valid Email Address",
                            Toast.LENGTH_LONG).show();
                }
            }

        });


    }


    public ArrayList<String> parseJSON(String result) {
        ArrayList<String> info = new ArrayList<String>();
        try {

            JSONObject info_json = new JSONObject(result);

            if (info_json.getString("found").equals("0"))
                info.add(info_json.getString("found"));

            else {

                int events = Integer.parseInt(info_json.getString("eventkey"));

                info.add(info_json.getString("regcode"));
                info.add(info_json.getString("fname"));
                info.add(info_json.getString("lname"));

                if (events > 12) {
                    info.add(info_json.getString("event13"));
                    info.add(info_json.getString("subevent13"));
                }

                if (events > 11) {
                    info.add(info_json.getString("event12"));
                    info.add(info_json.getString("subevent12"));
                }

                if (events > 10) {
                    info.add(info_json.getString("event11"));
                    info.add(info_json.getString("subevent11"));
                }

                if (events > 9) {
                    info.add(info_json.getString("event10"));
                    info.add(info_json.getString("subevent10"));
                }

                if (events > 8) {
                    info.add(info_json.getString("event9"));
                    info.add(info_json.getString("subevent9"));
                }

                if (events > 7) {
                    info.add(info_json.getString("event8"));
                    info.add(info_json.getString("subevent8"));
                }

                if (events > 6) {
                    info.add(info_json.getString("event7"));
                    info.add(info_json.getString("subevent7"));
                }

                if (events > 5) {
                    info.add(info_json.getString("event6"));
                    info.add(info_json.getString("subevent6"));
                }

                if (events > 4) {
                    info.add(info_json.getString("event5"));
                    info.add(info_json.getString("subevent5"));
                }

                if (events > 3) {
                    info.add(info_json.getString("event4"));
                    info.add(info_json.getString("subevent4"));
                }

                if (events > 2) {
                    info.add(info_json.getString("event3"));
                    info.add(info_json.getString("subevent3"));
                }

                if (events > 1) {
                    info.add(info_json.getString("event2"));
                    info.add(info_json.getString("subevent2"));
                }


                info.add(info_json.getString("event1"));
                info.add(info_json.getString("subevent1"));


                info.add(info_json.getString("eventkey"));

                //System.out.println(info.get(0) + "\n" + info.get(1) + "\n"+ info.get(2) + "\n"+ info.get(3) + "\n"+ info.get(4) + "\n"+ info.get(5) + "\n"+ info.get(6) + "\n"+ info.get(7) + "\n"+ info.get(8)+"\n"+info.size()+ "\n"+ info.get(9)+ "\n"+ info.get(10)+ "\n"+ info.get(11)+ "\n"+ info.get(12));
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

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


}