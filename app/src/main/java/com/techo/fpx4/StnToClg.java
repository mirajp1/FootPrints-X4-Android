package com.techo.fpx4;

import java.io.ByteArrayOutputStream;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

public class StnToClg extends SherlockActivity {

    Bitmap original;
    ByteArrayOutputStream out;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_stn_to_clg);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TouchImageView img = (TouchImageView) findViewById(R.id.map1);
        img.setMaxZoom(8);

        Toast.makeText(getApplicationContext(), "Double Click or Pinch the image to zoom in/out.",
                Toast.LENGTH_SHORT).show();

    }


}
