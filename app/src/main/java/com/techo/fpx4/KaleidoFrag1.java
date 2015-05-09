package com.techo.fpx4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.techo.fpx4.KaleidoEventActivity.ToFragmentK;

public class KaleidoFrag1 extends SherlockFragment implements ToFragmentK {

    String empty = "0";

    String PHOTO;
    String DATE_VENUE;
    String TEAM_I;
    String FEES_I;
    String INCHR_NUM_1;
    String INCHR_NUM_2;
    String INCHR_NAME_1;
    String INCHR_NAME_2;
    String INCHR_EMAIL_1;
    String INCHR_EMAIL_2;

    String inchr_contact_1;
    String inchr_contact_2;

    ImageView photo;

    TextView date_venue;
    TextView team_i;
    TextView fees_i;

    TextView inchr_name_1;
    TextView inchr_num_1;
    TextView inchr_email_1;

    TextView inchr_name_2;
    TextView inchr_num_2;
    TextView inchr_email_2;


    public static Fragment newInstance() {
        return new KaleidoFrag1();
    }


    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            this.DATE_VENUE = savedInstanceState.getString("date_venue");

            this.TEAM_I = savedInstanceState.getString("team");
            this.FEES_I = savedInstanceState.getString("fees");

            this.INCHR_NAME_1 = savedInstanceState.getString("inchr_name_1");
            this.INCHR_NUM_1 = savedInstanceState.getString("inchr_num_1");

            this.INCHR_NAME_2 = savedInstanceState.getString("inchr_name_2");
            this.INCHR_NUM_2 = savedInstanceState.getString("inchr_num_2");


            Log.v(getTag(), "frag 1 Oncreate savedInstanceState!=null ");
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.frag_kaleido_1, container, false);
        this.setRetainInstance(true);

        photo = (ImageView) view.findViewById(R.id.photo);
        date_venue = (TextView) view.findViewById(R.id.date_venue_i);

        team_i = (TextView) view.findViewById(R.id.team_i);
        fees_i = (TextView) view.findViewById(R.id.fees_i);

        inchr_name_1 = (TextView) view.findViewById(R.id.inchr_name_text_1);
        inchr_num_1 = (TextView) view.findViewById(R.id.inchr_num_text_1);
        inchr_email_1 = (TextView) view.findViewById(R.id.inchr_email_text_1);

        inchr_name_2 = (TextView) view.findViewById(R.id.inchr_name_text_2);
        inchr_num_2 = (TextView) view.findViewById(R.id.inchr_num_text_2);
        inchr_email_2 = (TextView) view.findViewById(R.id.inchr_email_text_2);

        RelativeLayout team_l = (RelativeLayout) view.findViewById(R.id.team_l);

        if (TEAM_I.equals(empty))
            team_l.setVisibility(View.GONE);


        //((TextView) view.findViewById(R.id.inchr_num_text_1)).getText().toString();
        //inchr_contact_2 = ((TextView) view.findViewById(R.id.inchr_num_text_2)).getText().toString();


        return view;
    }


    @SuppressLint("NewApi")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(INCHR_EMAIL_1);
                        Toast.makeText(getActivity().getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", INCHR_EMAIL_1);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getActivity().getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
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
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(INCHR_EMAIL_2);
                        Toast.makeText(getActivity().getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("email_1", INCHR_EMAIL_2);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getActivity().getApplicationContext(), "No apps can perform this action.\nEmail address copied to the clipboard", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

        photo.setImageResource(getResources().getIdentifier(PHOTO, "drawable", getActivity().getPackageName()));

        date_venue.setText(Html.fromHtml(DATE_VENUE));

        if (!TEAM_I.equals(empty))
            team_i.setText(TEAM_I);

        fees_i.setText(FEES_I);

        inchr_name_1.setText(INCHR_NAME_1);
        inchr_num_1.setText(INCHR_NUM_1);

        inchr_name_2.setText(INCHR_NAME_2);
        inchr_num_2.setText(INCHR_NUM_2);

    }


    @Override
    public void dataToFragmentK1(
            String PHOTO,
            String DATE_VENUE,
            String TEAM_I,
            String FEES_I,
            String INCHR_NUM_1,
            String INCHR_NUM_2,
            String INCHR_NAME_1,
            String INCHR_NAME_2,
            String INCHR_EMAIL_1,
            String INCHR_EMAIL_2) {

        this.PHOTO = PHOTO;
        this.DATE_VENUE = DATE_VENUE;
        this.TEAM_I = TEAM_I;
        this.FEES_I = FEES_I;
        this.INCHR_NAME_1 = INCHR_NAME_1;
        this.INCHR_NUM_1 = INCHR_NUM_1;
        this.INCHR_EMAIL_1 = INCHR_EMAIL_1;
        this.INCHR_NAME_2 = INCHR_NAME_2;
        this.INCHR_NUM_2 = INCHR_NUM_2;
        this.INCHR_EMAIL_2 = INCHR_EMAIL_2;
    }

    @Override
    public void dataToFragmentK2(
            String INFO,
            String WORKS_LAYOUT,
            String KIT
    ) {
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("date_venue", DATE_VENUE);
        savedInstanceState.putString("team", TEAM_I);
        savedInstanceState.putString("fees", FEES_I);

        savedInstanceState.putString("inchr_name_1", INCHR_NAME_1);
        savedInstanceState.putString("inchr_num_1", INCHR_NUM_1);

        savedInstanceState.putString("inchr_name_2", INCHR_NAME_2);
        savedInstanceState.putString("inchr_num_2", INCHR_NUM_2);

        Log.v(getTag(), "frag 1 save instance state ");
    }
}
