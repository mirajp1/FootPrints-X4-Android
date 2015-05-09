package com.techo.fpx4;

import java.util.ArrayList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;


public class MenuActivity extends SherlockActivity {

    private GridViewAdapter mAdapter;
    private ArrayList<Integer> buttonIconList;    //List of image ids for each button present in the drawables folder
    private ArrayList<Integer> buttonNameList;    //List of text ids for names of each button present in strings.xml
    private ArrayList<Integer> buttonDeptList;    //List of text ids for departments of each button. Not applicable to this activity so every value is set to 0.
    private GridView gridView;                    //The main gridview of the activity


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.get_fp_id:

                Intent intent0 = new Intent(MenuActivity.this, GetFpIdActivity.class);
                intent0.putExtra("actionBarTitle", "Get Your FP-ID");
                startActivity(intent0);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        prepareList();

        setTitle(R.string.app_name);

        // prepared arraylist and passed it to the Adapter class
        mAdapter = new GridViewAdapter(this, buttonNameList, buttonIconList, buttonDeptList);

        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.menuGridView);


        gridView.setAdapter(mAdapter);


        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                switch (itemPosition) {
                    case 0:
                        Intent intent0 = new Intent(MenuActivity.this, AboutUsActivity.class);
                        intent0.putExtra("actionBarIcon", "about_us_w");
                        startActivity(intent0);
                        break;

                    case 1:
                        Intent intent1 = new Intent(MenuActivity.this, MainActivity.class);
                        intent1.putExtra("actionBarIcon", "technotron_w");
                        intent1.putExtra("actionBarTitle", getResources().getString(R.string.kaleido));
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(MenuActivity.this, EventListActivity.class);
                        intent2.putExtra("actionBarTitle", getResources().getString(R.string.accommodation));
                        intent2.putExtra("actionBarIcon", "accommodation_w");
                        startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(MenuActivity.this, ScheduleActivity.class);
                        intent3.putExtra("actionBarIcon", "schedule_w");
                        intent3.putExtra("actionBarTitle", getResources().getString(R.string.schedule));
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(MenuActivity.this, MapActivity.class);
                        //intent4.putExtra("actionBarTitle","FSR");
                        intent4.putExtra("actionBarIcon", "map_w");
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(MenuActivity.this, ContactUsActivity.class);
                        intent5.putExtra("actionBarIcon", "contact_us_w");
                        startActivity(intent5);
                        break;


                    case 6:
                        Intent intent6 = new Intent(MenuActivity.this, FollowUsActivity.class);
                        intent6.putExtra("actionBarIcon", "follow_us_w");
                        startActivity(intent6);
                        break;

                    case 7:
                        Intent intent7 = new Intent(MenuActivity.this, CreditsActivity.class);
                        intent7.putExtra("actionBarIcon", "map_w");
                        startActivity(intent7);
                        break;


                }
            }
        });


    }


    public void prepareList() {

        buttonNameList = new ArrayList<Integer>();

        buttonNameList.add(R.string.about_us);
        buttonNameList.add(R.string.events);
        buttonNameList.add(R.string.accommodation);
        buttonNameList.add(R.string.schedule);
        buttonNameList.add(R.string.map);
        buttonNameList.add(R.string.contact_us);
        buttonNameList.add(R.string.follow_us);
        buttonNameList.add(R.string.credits);


        buttonIconList = new ArrayList<Integer>();

        buttonIconList.add(R.drawable.about_us);
        buttonIconList.add(R.drawable.event);
        buttonIconList.add(R.drawable.accommodation);
        buttonIconList.add(R.drawable.schedule);
        buttonIconList.add(R.drawable.map);
        buttonIconList.add(R.drawable.contact_us);
        buttonIconList.add(R.drawable.follow_us);
        buttonIconList.add(R.drawable.map);


        buttonDeptList = new ArrayList<Integer>();

        buttonDeptList.add(0);
        buttonDeptList.add(0);
        buttonDeptList.add(0);
        buttonDeptList.add(0);
        buttonDeptList.add(0);
        buttonDeptList.add(0);
        buttonDeptList.add(0);
        buttonDeptList.add(0);


    }


}