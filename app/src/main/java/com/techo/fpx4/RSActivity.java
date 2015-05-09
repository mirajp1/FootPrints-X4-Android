package com.techo.fpx4;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.actionbarsherlock.app.SherlockActivity;

public class RSActivity extends SherlockActivity {

    private WebView webView_rs;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rs);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Intent intent = getIntent();
        String ICON = intent.getStringExtra("actionBarIcon");

        final String actionBarTitle = intent.getStringExtra("actionBarTitle");
        //setTitle(actionBarTitle);
        getSupportActionBar().setIcon(getResources().getIdentifier(ICON, "drawable", getPackageName()));


        webView_rs = (WebView) findViewById(R.id.webView_rs);

        final Activity MyActivity = this;
        webView_rs.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                MyActivity.setTitle("Loading...");
                MyActivity.setProgress(progress * 100); //Make the bar disappear after URL is loaded

                if (progress == 100)
                    MyActivity.setTitle(actionBarTitle);
            }
        });
        
       /* final ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);

        webView_rs.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressDialog.show();
                progressDialog.setProgress(0);
                activity.setProgress(progress * 1000);

                progressDialog.incrementProgressBy(progress);

                if(progress == 100 && progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });*/

        webView_rs.getSettings().setJavaScriptEnabled(true);
        webView_rs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

        });

        webView_rs.loadUrl("http://www.msu-footprints.org/2014/rollingsquares/");


    }


}
