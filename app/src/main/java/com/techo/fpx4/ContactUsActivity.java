package com.techo.fpx4;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

@SuppressLint("NewApi")
public class ContactUsActivity extends SherlockActivity {

    String ICON;

    TextView head_ccm_num;
    TextView head_ccm_email;

    TextView a_head_ccm_num;
    TextView a_head_ccm_email;

    TextView reg_ccm_num_1;
    TextView reg_ccm_email_1;

    TextView reg_ccm_num_2;
    TextView reg_ccm_email_2;

    TextView reg_ccm_num_3;
    TextView reg_ccm_email_3;

    String contact_head_ccm;
    String email_head_ccm;

    String contact_a_head_ccm;
    String email_a_head_ccm;

    String contact_reg_ccm_1;
    String email_reg_ccm_1;

    String contact_reg_ccm_2;
    String email_reg_ccm_2;

    String contact_reg_ccm_3;
    String email_reg_ccm_3;


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_contact_us);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();
        ICON = intent.getStringExtra("actionBarIcon");

        getSupportActionBar().setIcon(getResources().getIdentifier(ICON, "drawable", getPackageName()));


        head_ccm_num = (TextView) findViewById(R.id.head_ccm_num_text);
        head_ccm_email = (TextView) findViewById(R.id.head_ccm_email_text);

        a_head_ccm_num = (TextView) findViewById(R.id.a_head_ccm_num_text);
        a_head_ccm_email = (TextView) findViewById(R.id.a_head_ccm_email_text);

        reg_ccm_num_1 = (TextView) findViewById(R.id.reg_ccm_num_text_1);
        reg_ccm_email_1 = (TextView) findViewById(R.id.reg_ccm_email_text_1);

        reg_ccm_num_2 = (TextView) findViewById(R.id.reg_ccm_num_text_2);
        reg_ccm_email_2 = (TextView) findViewById(R.id.reg_ccm_email_text_2);

        reg_ccm_num_3 = (TextView) findViewById(R.id.reg_ccm_num_text_3);
        reg_ccm_email_3 = (TextView) findViewById(R.id.reg_ccm_email_text_3);

        contact_head_ccm = getResources().getString(R.string.head_ccm_num);
        email_head_ccm = getResources().getString(R.string.head_ccm_email);

        contact_a_head_ccm = getResources().getString(R.string.a_head_ccm_num);
        email_a_head_ccm = getResources().getString(R.string.a_head_ccm_email);

        contact_reg_ccm_1 = getResources().getString(R.string.reg_ccm_num_1);
        email_reg_ccm_1 = getResources().getString(R.string.reg_ccm_email_1);

        contact_reg_ccm_2 = getResources().getString(R.string.reg_ccm_num_2);
        email_reg_ccm_2 = getResources().getString(R.string.reg_ccm_email_2);

        contact_reg_ccm_3 = getResources().getString(R.string.reg_ccm_num_3);
        email_reg_ccm_3 = getResources().getString(R.string.reg_ccm_email_3);


        head_ccm_num.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + contact_head_ccm));
                startActivity(call);
            }
        });

        head_ccm_email.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Intent email_1 = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:" + email_head_ccm);
                    email_1.setData(data);
                    startActivity(email_1);
                    //startActivity(Intent.createChooser(email_1,"Send Email Using: "));
                } catch (ActivityNotFoundException e) {

                    int sdk = android.os.Build.VERSION.SDK_INT;
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(email_head_ccm);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", email_head_ccm);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });


        a_head_ccm_num.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + contact_a_head_ccm));
                startActivity(call);
            }
        });

        a_head_ccm_email.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Intent email_1 = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:" + email_a_head_ccm);
                    email_1.setData(data);
                    startActivity(email_1);
                    //startActivity(Intent.createChooser(email_1,"Send Email Using: "));
                } catch (ActivityNotFoundException e) {

                    int sdk = android.os.Build.VERSION.SDK_INT;
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(email_a_head_ccm);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", email_a_head_ccm);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });


        reg_ccm_num_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + contact_reg_ccm_1));
                startActivity(call);
            }
        });

        reg_ccm_email_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Intent email_1 = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:" + email_reg_ccm_1);
                    email_1.setData(data);
                    startActivity(email_1);
                    //startActivity(Intent.createChooser(email_1,"Send Email Using: "));
                } catch (ActivityNotFoundException e) {

                    int sdk = android.os.Build.VERSION.SDK_INT;
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(email_reg_ccm_1);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", email_reg_ccm_1);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });


        reg_ccm_num_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + contact_reg_ccm_2));
                startActivity(call);
            }
        });

        reg_ccm_email_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Intent email_1 = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:" + email_reg_ccm_2);
                    email_1.setData(data);
                    startActivity(email_1);
                    //startActivity(Intent.createChooser(email_1,"Send Email Using: "));
                } catch (ActivityNotFoundException e) {

                    int sdk = android.os.Build.VERSION.SDK_INT;
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(email_reg_ccm_2);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", email_reg_ccm_2);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });


        reg_ccm_num_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + contact_reg_ccm_3));
                startActivity(call);
            }
        });

        reg_ccm_email_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Intent email_1 = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:" + email_reg_ccm_3);
                    email_1.setData(data);
                    startActivity(email_1);
                    //startActivity(Intent.createChooser(email_1,"Send Email Using: "));
                } catch (ActivityNotFoundException e) {

                    int sdk = android.os.Build.VERSION.SDK_INT;
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(email_reg_ccm_3);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", email_reg_ccm_3);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });


    }


}
