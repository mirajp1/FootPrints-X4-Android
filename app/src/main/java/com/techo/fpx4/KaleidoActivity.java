package com.techo.fpx4;

import java.util.ArrayList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;

public class KaleidoActivity extends SherlockActivity {

    private ListViewAdapter mAdapter_gl;
    private ArrayList<Integer> icon_gl;
    private ArrayList<String> listDescription_gl;
    private ArrayList<String> event_list_gl;

    private ListViewAdapter mAdapter_wk;
    private ArrayList<Integer> icon_wk;
    private ArrayList<String> listDescription_wk;
    private ArrayList<String> event_list_wk;

    ListView listView_gl;
    ListView listView_wk;

    DataBaseHelper dbh;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_kaleido);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final String actionBarTitle = getIntent().getExtras().getString("actionBarTitle");
        setTitle(actionBarTitle);

        final String actionBarIcon = getIntent().getExtras().getString("actionBarIcon");
        getSupportActionBar().setIcon(getResources().getIdentifier(actionBarIcon, "drawable", getPackageName()));

        String tableName_gl = "GuestLectures";
        String tableName_wk = "Workshops";

        event_list_gl = new ArrayList<String>();
        listDescription_gl = new ArrayList<String>();
        icon_gl = new ArrayList<Integer>();

        event_list_wk = new ArrayList<String>();
        listDescription_wk = new ArrayList<String>();
        icon_wk = new ArrayList<Integer>();


        dbh = new DataBaseHelper(this);
        Cursor c_gl = dbh.getEventList(tableName_gl);
        Cursor c_wk = dbh.getEventList(tableName_wk);

        if ((c_gl.getCount() == 0) || !c_gl.moveToFirst()) {
            throw new SQLException("No Data found ");
        }

        if ((c_wk.getCount() == 0 || !c_wk.moveToFirst())) {
            throw new SQLException("No Data Found");
        }

        do {
            event_list_gl.add(c_gl.getString(1));
            listDescription_gl.add(c_gl.getString(2));
            icon_gl.add(getResources().getIdentifier(c_gl.getString(0), "drawable", getPackageName()));
        } while (c_gl.moveToNext());

        c_gl.close();

        do {
            event_list_wk.add(c_wk.getString(1));
            listDescription_wk.add(c_wk.getString(2));
            icon_wk.add(getResources().getIdentifier(c_wk.getString(0), "drawable", getPackageName()));
        } while (c_wk.moveToNext());


        c_wk.close();
        dbh.close();

        mAdapter_gl = new ListViewAdapter(this, event_list_gl, icon_gl, listDescription_gl);
        listView_gl = (ListView) findViewById(R.id.listview_guest_lec);

        listView_gl.setAdapter(mAdapter_gl);

        listView_gl.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition_gl = position;
                //String itemValue=(String)listview.getItemAtPosition(position);

                switch (itemPosition_gl) {
                    case 0:
                        Intent intent0 = new Intent(KaleidoActivity.this, KaleidoEventActivity.class);
                        intent0.putExtra("actionBarTitle", event_list_gl.get(0));
                        intent0.putExtra("department", "GuestLectures");
                        startActivity(intent0);
                        break;


                    case 1:
                        Intent intent1 = new Intent(KaleidoActivity.this, KaleidoEventActivity.class);
                        intent1.putExtra("actionBarTitle", event_list_gl.get(1));
                        intent1.putExtra("department", "GuestLectures");
                        startActivity(intent1);
                        break;


                    case 2:
                        Intent intent2 = new Intent(KaleidoActivity.this, KaleidoEventActivity.class);
                        intent2.putExtra("actionBarTitle", event_list_gl.get(2));
                        intent2.putExtra("department", "GuestLectures");
                        startActivity(intent2);
                        break;


                    case 3:
                        Intent intent3 = new Intent(KaleidoActivity.this, KaleidoEventActivity.class);
                        intent3.putExtra("actionBarTitle", event_list_gl.get(3));
                        intent3.putExtra("department", "GuestLectures");
                        startActivity(intent3);
                        break;


                }
            }
        });


        mAdapter_wk = new ListViewAdapter(this, event_list_wk, icon_wk, listDescription_wk);
        listView_wk = (ListView) findViewById(R.id.listview_workshops);

        listView_wk.setAdapter(mAdapter_wk);

        listView_wk.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition_wk = position;
                //String itemValue=(String)listview.getItemAtPosition(position);

                switch (itemPosition_wk) {
                    case 0:
                        Intent intent0 = new Intent(KaleidoActivity.this, KaleidoEventActivity.class);
                        intent0.putExtra("actionBarTitle", event_list_wk.get(0));
                        intent0.putExtra("department", "Workshops");
                        startActivity(intent0);
                        break;


                    case 1:
                        Intent intent1 = new Intent(KaleidoActivity.this, KaleidoEventActivity.class);
                        intent1.putExtra("actionBarTitle", event_list_wk.get(1));
                        intent1.putExtra("department", "Workshops");
                        startActivity(intent1);
                        break;


                    case 2:
                        Intent intent2 = new Intent(KaleidoActivity.this, KaleidoEventActivity.class);
                        intent2.putExtra("actionBarTitle", event_list_wk.get(2));
                        intent2.putExtra("department", "Workshops");
                        startActivity(intent2);
                        break;


                }
            }
        });

        //hack for showing all listview items without listview scrolling
        setListViewHeightBasedOnChildren(listView_wk);
        setListViewHeightBasedOnChildren(listView_gl);


    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }


}
