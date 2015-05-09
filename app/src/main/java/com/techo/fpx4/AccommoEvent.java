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
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BulletSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

@SuppressLint("NewApi")
public class AccommoEvent extends SherlockActivity {


    String empty = "0";

    String PHOTO;
    String DURATION_I;
    String FEES_I;
    String ADDRESS_I;
    String DETAILS_I;
    String RULES_I;
    String TERMSNCONDI_I;

    String INCHR_NUM_1;
    String INCHR_NUM_2;
    String INCHR_NAME_1;
    String INCHR_NAME_2;
    String INCHR_EMAIL_1;
    String INCHR_EMAIL_2;

    ImageView photo;
    TextView duration_i;
    TextView fees_i;
    TextView address_i;
    TextView details_i;
    TextView rules_i;
    TextView termsncondi_i;

    TextView inchr_name_1;
    TextView inchr_num_1;
    TextView inchr_email_1;

    TextView inchr_name_2;
    TextView inchr_num_2;
    TextView inchr_email_2;
    RelativeLayout photo_l;

    String str_rules;
    String str_details;
    String str_termsncondi;

    SpannableStringBuilder sb_rules = new SpannableStringBuilder();
    SpannableStringBuilder sb_details = new SpannableStringBuilder();
    SpannableStringBuilder sb_termsncondi = new SpannableStringBuilder();

    String deptName, eventName;

    DataBaseHelper dbh;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accommo_event);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        photo_l = (RelativeLayout) findViewById(R.id.photo_l);

        photo = (ImageView) findViewById(R.id.photo);


        duration_i = (TextView) findViewById(R.id.duration_i);
        fees_i = (TextView) findViewById(R.id.fees_i);
        address_i = (TextView) findViewById(R.id.address_i);
        details_i = (TextView) findViewById(R.id.details_i);
        rules_i = (TextView) findViewById(R.id.rules_i);
        termsncondi_i = (TextView) findViewById(R.id.termsncondi_i);

        inchr_name_1 = (TextView) findViewById(R.id.inchr_name_text_1);
        inchr_num_1 = (TextView) findViewById(R.id.inchr_num_text_1);
        inchr_email_1 = (TextView) findViewById(R.id.inchr_email_text_1);

        inchr_name_2 = (TextView) findViewById(R.id.inchr_name_text_2);
        inchr_num_2 = (TextView) findViewById(R.id.inchr_num_text_2);
        inchr_email_2 = (TextView) findViewById(R.id.inchr_email_text_2);


        if (savedInstanceState != null) {

            this.PHOTO = savedInstanceState.getString("photo");

            this.DURATION_I = savedInstanceState.getString("duration");
            this.FEES_I = savedInstanceState.getString("fees");
            this.ADDRESS_I = savedInstanceState.getString("address");
            this.DETAILS_I = savedInstanceState.getString("details");
            this.RULES_I = savedInstanceState.getString("rules");
            this.TERMSNCONDI_I = savedInstanceState.getString("termsncondi");

            this.INCHR_NAME_1 = savedInstanceState.getString("inchr_name_1");
            this.INCHR_NUM_1 = savedInstanceState.getString("inchr_num_1");

            this.INCHR_NAME_2 = savedInstanceState.getString("inchr_name_2");
            this.INCHR_NUM_2 = savedInstanceState.getString("inchr_num_2");


        } else {

            Intent intent = getIntent();
            deptName = intent.getStringExtra("department");

            String actionBarTitle = intent.getStringExtra("actionBarTitle");
            setTitle(actionBarTitle); //Sets the title in ActionBar

            eventName = actionBarTitle;

            dbh = new DataBaseHelper(this);
            String[] eventNametoDB = {eventName};

            Cursor c = dbh.getAnEvent(eventNametoDB, deptName);
            if ((c.getCount() == 0) || !c.moveToFirst()) {
                throw new SQLException("No Data found ");
            }

            do {
                PHOTO = c.getString(2);

                DURATION_I = c.getString(3);
                FEES_I = c.getString(4);
                ADDRESS_I = c.getString(5);
                DETAILS_I = c.getString(6);
                RULES_I = c.getString(7);
                TERMSNCONDI_I = c.getString(8);

                INCHR_NAME_1 = c.getString(9);
                INCHR_NUM_1 = c.getString(10);
                INCHR_EMAIL_1 = c.getString(11);
                INCHR_NAME_2 = c.getString(12);
                INCHR_NUM_2 = c.getString(13);
                INCHR_EMAIL_2 = c.getString(14);


            }
            while (c.moveToNext());

            c.close();
            dbh.close();

        }


        getSupportActionBar().setIcon(R.drawable.accommodation_w);

        if (PHOTO.equals(empty))
            photo_l.setVisibility(View.GONE);


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


        str_rules = RULES_I;

        String[] list_rules = str_rules.split("\n");  //split the string on the delimiter

        SpannableString span_rules = new SpannableString(str_rules); //create the spannablestring

        int spanPosition_rules = 0; //we'll need to keep track of our start position

        for (int i = 0; i < list_rules.length; i++) {

            span_rules.setSpan(new BulletSpan(5), spanPosition_rules, spanPosition_rules + list_rules[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            sb_rules.append(span_rules, spanPosition_rules, spanPosition_rules + list_rules[i].length());
            sb_rules.append("\n\n");
            spanPosition_rules += list_rules[i].length() + 1;

        }

        sb_rules.delete(sb_rules.length() - 2, sb_rules.length());


        str_details = DETAILS_I;

        String[] list_details = str_details.split("\n");  //split the string on the delimiter

        SpannableString span_details = new SpannableString(str_details); //create the spannablestring

        int spanPosition_details = 0; //we'll need to keep track of our start position

        for (int i = 0; i < list_details.length; i++) {

            span_details.setSpan(new BulletSpan(5), spanPosition_details, spanPosition_details + list_details[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            sb_details.append(span_details, spanPosition_details, spanPosition_details + list_details[i].length());
            sb_details.append("\n\n");
            spanPosition_details += list_details[i].length() + 1;

        }

        sb_details.delete(sb_details.length() - 2, sb_details.length());


        str_termsncondi = TERMSNCONDI_I;

        String[] list_termsncondi = str_termsncondi.split("\n");  //split the string on the delimiter

        SpannableString span_termsncondi = new SpannableString(str_termsncondi); //create the spannablestring

        int spanPosition_termsncondi = 0; //we'll need to keep track of our start position

        for (int i = 0; i < list_termsncondi.length; i++) {

            span_termsncondi.setSpan(new BulletSpan(5), spanPosition_termsncondi, spanPosition_termsncondi + list_termsncondi[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            sb_termsncondi.append(span_termsncondi, spanPosition_termsncondi, spanPosition_termsncondi + list_termsncondi[i].length());
            sb_termsncondi.append("\n\n");
            spanPosition_termsncondi += list_termsncondi[i].length() + 1;

        }

        sb_termsncondi.delete(sb_termsncondi.length() - 2, sb_termsncondi.length());

    }

    @Override
    public void onResume() {
        super.onResume();

        if (!PHOTO.equals(empty))
            photo.setImageResource(getResources().getIdentifier(PHOTO, "drawable", getPackageName()));

        duration_i.setText(DURATION_I);
        fees_i.setText(FEES_I);
        address_i.setText(ADDRESS_I);
        details_i.setText(sb_details);
        rules_i.setText(sb_rules);
        termsncondi_i.setText(sb_termsncondi);

        inchr_name_1.setText(INCHR_NAME_1);
        inchr_num_1.setText(INCHR_NUM_1);

        inchr_name_2.setText(INCHR_NAME_2);
        inchr_num_2.setText(INCHR_NUM_2);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);


        savedInstanceState.putString("duration", DURATION_I);
        savedInstanceState.putString("fees", FEES_I);
        savedInstanceState.putString("details", DETAILS_I);
        savedInstanceState.putString("rules", RULES_I);
        savedInstanceState.putString("address", ADDRESS_I);
        savedInstanceState.putString("termsncondi", TERMSNCONDI_I);

        savedInstanceState.putString("inchr_name_1", INCHR_NAME_1);
        savedInstanceState.putString("inchr_num_1", INCHR_NUM_1);

        savedInstanceState.putString("inchr_name_2", INCHR_NAME_2);
        savedInstanceState.putString("inchr_num_2", INCHR_NUM_2);


    }


}
