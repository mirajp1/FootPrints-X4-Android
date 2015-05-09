package com.techo.fpx4;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class EventActivity extends SherlockFragmentActivity {

    private Fragment fragment1, fragment2, fragment3;

    private ActionBar actionBar;
    private ViewPager viewPager;

    String deptName, eventName;

    DataBaseHelper dbh;


    String PROB_STMNT_I;
    String TEAM_I;
    String FEES_I;
    String INCHR_NUM_1;
    String INCHR_NUM_2;
    String INCHR_NAME_1;
    String INCHR_NAME_2;
    String INCHR_EMAIL_1;
    String INCHR_EMAIL_2;

    String ROUNDS_I;
    String JUDG_CRIT_I;
    String ABSTRACT_I;

    String RULES_I;
    String SPECS_I;


    public ToFragment toFragment1Communicator;
    public ToFragment toFragment2Communicator;
    public ToFragment toFragment3Communicator;

    public interface ToFragment {
        public void dataToFragment1(
                String PROB_STMNT_I,
                String TEAM_I,
                String FEES_I,
                String INCHR_NUM_1,
                String INCHR_NUM_2,
                String INCHR_NAME_1,
                String INCHR_NAME_2,
                String INCHR_EMAIL_1,
                String INCHR_EMAIL_2
        );

        public void dataToFragment2(
                String ROUNDS_I,
                String JUDG_CRIT_I,
                String ABSTRACT_I
        );

        public void dataToFragment3(
                String RULES_I,
                String SPECS_I
        );

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_event);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        viewPager = (ViewPager) findViewById(R.id.technoEventPager);
        viewPager.setOnPageChangeListener(onPageChangeListener);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(2);
        FragmentStatePagerAdapter a = (FragmentStatePagerAdapter) viewPager.getAdapter();

        if (savedInstanceState != null) {

            Log.v("FsdfS", "frag activity Oncreate savedInstanceState!=null ");

            //Get fragment instances from savedInstanceState when activity is recreated

            fragment1 = getSupportFragmentManager().getFragment(savedInstanceState, "frag1");
            fragment2 = getSupportFragmentManager().getFragment(savedInstanceState, "frag2");
            fragment3 = getSupportFragmentManager().getFragment(savedInstanceState, "frag3");

            //get values of strings from savedInstanceState

            this.ROUNDS_I = savedInstanceState.getString("rounds_i");
            this.PROB_STMNT_I = savedInstanceState.getString("prob_stmnt_i");
        } else {

            Intent intent = getIntent();
            deptName = intent.getStringExtra("department");
            // deptName.toUpperCase(); //to change it into TABLE NAME

            String actionBarTitle = intent.getStringExtra("actionBarTitle");
            setTitle(actionBarTitle); //Sets the title in ActionBar

            eventName = actionBarTitle;

            addActionBarTabs(); //add the tabs in actionbar

            fragment1 = (Fragment) a.instantiateItem(viewPager, 0); //get Fragment instance to this variable
            fragment2 = (Fragment) a.instantiateItem(viewPager, 1);
            fragment3 = (Fragment) a.instantiateItem(viewPager, 2);

            dbh = new DataBaseHelper(this);
            String[] eventNametoDB = {eventName};

            Cursor c = dbh.getAnEvent(eventNametoDB, deptName);
            if ((c.getCount() == 0) || !c.moveToFirst()) {
                throw new SQLException("No Data found ");
            }

            do {
                PROB_STMNT_I = c.getString(2);
                TEAM_I = c.getString(3);
                FEES_I = c.getString(4);
                INCHR_NAME_1 = c.getString(5);
                INCHR_NUM_1 = c.getString(6);
                INCHR_EMAIL_1 = c.getString(7);
                INCHR_NAME_2 = c.getString(8);
                INCHR_NUM_2 = c.getString(9);
                INCHR_EMAIL_2 = c.getString(10);

                ROUNDS_I = c.getString(11);
                JUDG_CRIT_I = c.getString(12);
                ABSTRACT_I = c.getString(13);

                RULES_I = c.getString(14);
                SPECS_I = c.getString(15);
            }
            while (c.moveToNext());

            c.close();
            dbh.close();

        }

        //getSupportActionBar().setIcon(getResources().getIdentifier(ICON,"drawable",getPackageName())); //set title bar icon
        getSupportActionBar().setIcon(R.drawable.event_w); //set title bar icon

    }

    @Override
    public void onResume() {
        super.onResume();

        toFragment1Communicator = (ToFragment) fragment1;
        toFragment2Communicator = (ToFragment) fragment2;
        toFragment3Communicator = (ToFragment) fragment3;

        if (toFragment1Communicator != null && toFragment2Communicator != null) {
            toFragment1Communicator.dataToFragment1(
                    PROB_STMNT_I,
                    TEAM_I,
                    FEES_I,
                    INCHR_NUM_1,
                    INCHR_NUM_2,
                    INCHR_NAME_1,
                    INCHR_NAME_2,
                    INCHR_EMAIL_1,
                    INCHR_EMAIL_2
            );

            toFragment2Communicator.dataToFragment2(
                    ROUNDS_I,
                    JUDG_CRIT_I,
                    ABSTRACT_I
            );

            toFragment3Communicator.dataToFragment3(
                    RULES_I,
                    SPECS_I
            );
        }

    }


    private ViewPager.SimpleOnPageChangeListener onPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            actionBar.setSelectedNavigationItem(position);
        }
    };

    private void addActionBarTabs() {
        actionBar = getSupportActionBar();
        String[] tabs = {"General", "Rounds", "         Rules/ Specifications"}; //Number and Name of Tabs in details of an event
        for (String tabTitle : tabs) {
            ActionBar.Tab tab = actionBar.newTab().setText(tabTitle)
                    .setTabListener(tabListener);
            actionBar.addTab(tab);
        }
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    }


    private ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            viewPager.setCurrentItem(tab.getPosition());

        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }
    };

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);

        if (fragment1 != null)
            getSupportFragmentManager().putFragment(state, "frag1", fragment1);
        if (fragment2 != null)
            getSupportFragmentManager().putFragment(state, "frag2", fragment2);
        if (fragment3 != null)
            getSupportFragmentManager().putFragment(state, "frag3", fragment3);

        state.putString("prob_stmnt_i", PROB_STMNT_I);
        state.putString("rules_i", ROUNDS_I);

        Log.v("Sfsdfs", "frag activity saveInstanceState ");
    }


}
