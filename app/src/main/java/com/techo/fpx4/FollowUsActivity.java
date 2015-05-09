package com.techo.fpx4;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;


public class FollowUsActivity extends SherlockActivity {


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_follow_us);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();
        String ICON = intent.getStringExtra("actionBarIcon");
        getSupportActionBar().setIcon(getResources().getIdentifier(ICON, "drawable", getPackageName()));

        TextView website_tv = (TextView) findViewById(R.id.website);
        final Uri ws = Uri.parse("http://www.msu-footprints.org/2014");

        TextView on_reg_tv = (TextView) findViewById(R.id.on_reg);
        final Uri on_reg = Uri.parse("http://www.msu-footprints.org/registerx4");

        TextView fb_tv = (TextView) findViewById(R.id.fb);
        final Uri fb = Uri.parse("http://www.facebook.com/msufp");

        TextView yt_tv = (TextView) findViewById(R.id.yt);
        final Uri yt = Uri.parse("http://www.youtube.com/FootPrintsMSU");

        TextView twit_tv = (TextView) findViewById(R.id.twit);
        final Uri twit = Uri.parse("http://www.twitter.com/FP_thinkbeyond");

        TextView li_tv = (TextView) findViewById(R.id.li);
        final Uri li = Uri.parse("http://www.linkedin.com/company/footprints---think-beyond");

        TextView quora_tv = (TextView) findViewById(R.id.quora);
        final Uri quora = Uri.parse("http://www.quora.com/FootPrints-think-BEYOND");


        website_tv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent launchB = new Intent(Intent.ACTION_VIEW, ws);
                startActivity(launchB);

            }


        });

        on_reg_tv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent launchB = new Intent(Intent.ACTION_VIEW, on_reg);
                startActivity(launchB);

            }


        });

        fb_tv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent launchB = new Intent(Intent.ACTION_VIEW, fb);
                startActivity(launchB);

            }


        });


        yt_tv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent launchB = new Intent(Intent.ACTION_VIEW, yt);
                startActivity(launchB);

            }


        });


        twit_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent launchB = new Intent(Intent.ACTION_VIEW, twit);
                startActivity(launchB);

            }


        });


        li_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent launchB = new Intent(Intent.ACTION_VIEW, li);
                startActivity(launchB);

            }


        });

        quora_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent launchB = new Intent(Intent.ACTION_VIEW, quora);
                startActivity(launchB);

            }


        });


    }


}
