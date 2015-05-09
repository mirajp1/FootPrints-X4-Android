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


public class MainActivity extends SherlockActivity {

    private GridViewAdapter mAdapter;
    private ArrayList<Integer> buttonIconList;    //List of image ids for each button present in the drawables folder
    private ArrayList<Integer> buttonNameList;    //List of text ids for names of each button present in strings.xml
    private ArrayList<Integer> buttonDeptList;    //List of text ids for departments of each button. Not applicable to this activity so every value is set to 0.
    private GridView gridView;                    //The main gridview of the activity


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        prepareList();
        setTitle("Events");
        getSupportActionBar().setIcon(R.drawable.event_w);

        // prepared arraylist and passed it to the Adapter class
        mAdapter = new GridViewAdapter(this, buttonNameList, buttonIconList, buttonDeptList);

        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.mainGridView);


        gridView.setAdapter(mAdapter);


        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                switch (itemPosition) {
                    case 0:
                        Intent intent0 = new Intent(MainActivity.this, TechnotronActivity.class);
                        intent0.putExtra("actionBarIcon", "technotron_w");
                        startActivity(intent0);
                        break;

                    case 1:
                        Intent intent1 = new Intent(MainActivity.this, KaleidoActivity.class);
                        intent1.putExtra("actionBarIcon", "kaleido_w");
                        intent1.putExtra("actionBarTitle", getResources().getString(R.string.kaleido));
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, EventListActivity.class);
                        intent2.putExtra("actionBarTitle", getResources().getString(R.string.quest));
                        intent2.putExtra("actionBarIcon", "quest_w");
                        startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, RSActivity.class);
                        intent3.putExtra("actionBarIcon", "rs_w");
                        intent3.putExtra("actionBarTitle", getResources().getString(R.string.rs));
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(MainActivity.this, FSRActivity.class);
                        intent4.putExtra("actionBarTitle", "FSR");
                        intent4.putExtra("actionBarIcon", "fsr_w");
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(MainActivity.this, EventListActivity.class);
                        intent5.putExtra("actionBarTitle", "FSE");
                        intent5.putExtra("actionBarIcon", "fse_w");
                        startActivity(intent5);
                        break;

                    case 6:
                        Intent intent6 = new Intent(MainActivity.this, EventListActivity.class);
                        intent6.putExtra("actionBarTitle", getResources().getString(R.string.addons));
                        intent6.putExtra("actionBarIcon", "addons_w");
                        startActivity(intent6);
                        break;

                    case 7:
                        Intent intent7 = new Intent(MainActivity.this, EventListActivity.class);
                        intent7.putExtra("actionBarTitle", getResources().getString(R.string.virtuosity));
                        intent7.putExtra("actionBarIcon", "virtuosity_w");
                        startActivity(intent7);
                        break;

                }
            }
        });


    }


    public void prepareList() {

        buttonNameList = new ArrayList<Integer>();

        buttonNameList.add(R.string.techno);
        buttonNameList.add(R.string.kaleido);
        buttonNameList.add(R.string.quest);
        buttonNameList.add(R.string.rs);
        buttonNameList.add(R.string.fsr);
        buttonNameList.add(R.string.fse);
        buttonNameList.add(R.string.addons);
        buttonNameList.add(R.string.virtuosity);


        buttonIconList = new ArrayList<Integer>();

        buttonIconList.add(R.drawable.technotron);
        buttonIconList.add(R.drawable.kaleido);
        buttonIconList.add(R.drawable.quest);
        buttonIconList.add(R.drawable.rs);
        buttonIconList.add(R.drawable.fsr);
        buttonIconList.add(R.drawable.fse);
        buttonIconList.add(R.drawable.addons);
        buttonIconList.add(R.drawable.virtuosity);


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

	
	
	/*
	@Override
	public void onClick(View v) {
		int id=v.getId();
		switch(id){
		
		case R.id.technotron:
			
			
			Intent intent = new Intent(MainActivity.this, TechnoActivity.class);
			startActivity(intent);
			break;
			
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
	*/
	
	
	





