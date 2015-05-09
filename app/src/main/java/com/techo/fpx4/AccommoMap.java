package com.techo.fpx4;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

public class AccommoMap extends SherlockActivity {


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accommo_map);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TouchImageView img = (TouchImageView) findViewById(R.id.map4);
        img.setMaxZoom(8);

        Toast.makeText(getApplicationContext(), "Double Click or Pinch the image to zoom in/out.",
                Toast.LENGTH_SHORT).show();
    }


}
