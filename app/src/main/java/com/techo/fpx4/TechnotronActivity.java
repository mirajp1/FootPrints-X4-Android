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


public class TechnotronActivity extends SherlockActivity {// implements OnClickListener {

    private GridViewAdapter mAdapter;
    private ArrayList<Integer> buttonIconList;        //List of image ids for each button present in the drawables folder
    private ArrayList<Integer> buttonNameList;        //List of text ids for names of each button present in strings.xml
    private ArrayList<Integer> buttonDeptList;        //List of text ids for departments of each button.
    private GridView gridView;                        //The main gridview of the activity


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_techno);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final String actionBarIcon = getIntent().getExtras().getString("actionBarIcon");

        setTitle(getResources().getString(R.string.techno)); //Sets the title in ActionBar

        getSupportActionBar().setIcon(getResources().getIdentifier(actionBarIcon, "drawable", getPackageName()));

        prepareList();

        // prepared arraylist and passed it to the Adapter class
        mAdapter = new GridViewAdapter(this, buttonNameList, buttonIconList, buttonDeptList);

        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.technoGridView);


        gridView.setAdapter(mAdapter);


        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                //String itemValue=(String)listview.getItemAtPosition(position);

                switch (itemPosition) {
                    case 0:
                        Intent intent0 = new Intent(TechnotronActivity.this, EventListActivity.class);
                        //intent0.putExtra("event_list",getResources().getStringArray(R.array.eventList_cyber));
                        intent0.putExtra("actionBarTitle", getResources().getString(R.string.tech_cyber));
                        intent0.putExtra("actionBarIcon", "cyber_w");
                        startActivity(intent0);
                        break;

                    case 1:
                        Intent intent1 = new Intent(TechnotronActivity.this, EventListActivity.class);
                        //intent1.putExtra("event_list",getResources().getStringArray(R.array.eventList_sanga));
                        intent1.putExtra("actionBarTitle", getResources().getString(R.string.tech_sanga));
                        intent1.putExtra("actionBarIcon", "sanga_w");
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(TechnotronActivity.this, EventListActivity.class);
                        //intent2.putExtra("event_list",getResources().getStringArray(R.array.eventList_mech));
                        intent2.putExtra("actionBarTitle", getResources().getString(R.string.tech_mech));
                        intent2.putExtra("actionBarIcon", "mech_w");
                        startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(TechnotronActivity.this, EventListActivity.class);
                        //intent3.putExtra("event_list",getResources().getStringArray(R.array.eventList_citadel));
                        intent3.putExtra("actionBarTitle", getResources().getString(R.string.tech_citadel));
                        intent3.putExtra("actionBarIcon", "citadel_w");
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(TechnotronActivity.this, EventListActivity.class);
                        //intent4.putExtra("event_list",getResources().getStringArray(R.array.eventList_rasay));
                        intent4.putExtra("actionBarTitle", getResources().getString(R.string.tech_rasay));
                        intent4.putExtra("actionBarIcon", "rasay_w");
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(TechnotronActivity.this, EventListActivity.class);
                        //intent5.putExtra("event_list",getResources().getStringArray(R.array.eventList_lycra));
                        intent5.putExtra("actionBarTitle", getResources().getString(R.string.tech_lycra));
                        intent5.putExtra("actionBarIcon", "lycra_w");
                        startActivity(intent5);
                        break;

                    case 6:
                        Intent intent6 = new Intent(TechnotronActivity.this, EventActivity.class);
                        //intent6.putExtra("event_list",getResources().getStringArray(R.array.eventList_openx));
                        intent6.putExtra("actionBarTitle", getResources().getString(R.string.tech_openx));
                        intent6.putExtra("department", "openx");
                        intent6.putExtra("actionBarIcon", "openx_w");
                        startActivity(intent6);
                        break;

                    case 7:
                        Intent intent7 = new Intent(TechnotronActivity.this, EventActivity.class);
                        //intent7.putExtra("event_list",getResources().getStringArray(R.array.eventList_contrap));
                        intent7.putExtra("actionBarTitle", getResources().getString(R.string.tech_contrap));
                        intent7.putExtra("department", getResources().getString(R.string.tech_contrap));
                        startActivity(intent7);
                        break;


                    case 8:
                        Intent intent8 = new Intent(TechnotronActivity.this, EventActivity.class);
                        //intent7.putExtra("event_list",getResources().getStringArray(R.array.eventList_contrap));
                        intent8.putExtra("actionBarTitle", getResources().getString(R.string.tech_cadmania));
                        intent8.putExtra("department", "CADMANIA");
                        startActivity(intent8);
                        break;

                }
            }
        });


    }


    public void prepareList() {
        buttonNameList = new ArrayList<Integer>();

        buttonNameList.add(R.string.tech_cyber);
        buttonNameList.add(R.string.tech_sanga);
        buttonNameList.add(R.string.tech_mech);
        buttonNameList.add(R.string.tech_citadel);
        buttonNameList.add(R.string.tech_rasay);
        buttonNameList.add(R.string.tech_lycra);
        buttonNameList.add(R.string.tech_openx);
        buttonNameList.add(R.string.tech_contrap);
        buttonNameList.add(R.string.tech_cadmania);


        buttonDeptList = new ArrayList<Integer>();

        buttonDeptList.add(R.string.tech_cyber_dept);
        buttonDeptList.add(R.string.tech_sanga_dept);
        buttonDeptList.add(R.string.tech_mech_dept);
        buttonDeptList.add(R.string.tech_citadel_dept);
        buttonDeptList.add(R.string.tech_rasay_dept);
        buttonDeptList.add(R.string.tech_lycra_dept);
        buttonDeptList.add(R.string.tech_openx_dept);
        buttonDeptList.add(R.string.tech_contrap_dept);
        buttonDeptList.add(R.string.tech_cadmania_dept);


        buttonIconList = new ArrayList<Integer>();

        buttonIconList.add(R.drawable.cyber);
        buttonIconList.add(R.drawable.sanga);
        buttonIconList.add(R.drawable.mech);
        buttonIconList.add(R.drawable.citadel);
        buttonIconList.add(R.drawable.rasay);
        buttonIconList.add(R.drawable.lycra);
        buttonIconList.add(R.drawable.openx);
        buttonIconList.add(R.drawable.contrap);
        buttonIconList.add(R.drawable.event);


    }


}	




/* package com.techo.fpx4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class TechnoActivity extends SherlockActivity implements OnClickListener {

	private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
	
	String[] title = {
			"Cybernetics",
			"Sanganikee",
			"Macheanema",
			"Citadel",
			"Rasayanam",
			"Lycra",
			"Open-X",
			"Contraption"
	};
	
	String[] eventList_cyber = {
			"Runtime",
			"Bytecode",
			"Appster",
			"Protocol"
		};
	
	String[] eventList_sanga = {
			"Fsfdsf",
			"sfdfsds",
			"sfdsd"
	};
	
	String[] eventList_mech = {
			"Fsfdsf",
			"sfdfsds",
			"sfdsd"
	};
	
	String[] eventList_citadel = {
			"Fsfdsf",
			"sfdfsds",
			"sfdsd"
	};
	
	String[] eventList_rasay = {
			"Fsfdsf",
			"sfdfsds",
			"sfdsd"
	};
	
	String[] eventList_lycra = {
			"Fsfdsf",
			"sfdfsds",
			"sfdsd"
	};
	
	String[] eventList_openx = {
			"Fsfdsf",
			"sfdfsds",
			"sfdsd"
	};
	
	String[] eventList_contrap = {
			"Fsfdsf",
			"sfdfsds",
			"sfdsd"
	};
		
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_techno);
		// Show the Up button in the action bar.
		//setupActionBar();
		
		btn1= (Button)findViewById(R.id.but1);
		btn1.setOnClickListener(this);
		
		btn2= (Button)findViewById(R.id.but2);
		btn2.setOnClickListener(this);
		
		btn3= (Button)findViewById(R.id.but3);
		btn3.setOnClickListener(this);
		
		btn4= (Button)findViewById(R.id.but4);
		btn4.setOnClickListener(this);
	
		btn5= (Button)findViewById(R.id.but5);
		btn5.setOnClickListener(this);
		
		btn6= (Button)findViewById(R.id.but6);
		btn6.setOnClickListener(this);
		
		btn7= (Button)findViewById(R.id.but7);
		btn7.setOnClickListener(this);
		
		btn8= (Button)findViewById(R.id.but8);
		btn8.setOnClickListener(this);
		
		
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.sherlock_techno, menu);
		return true;
	}

	
	
	
	@Override
	public void onClick(View v) {
		int id=v.getId();
		
		switch(id){
		
		case R.id.but1:
			
			Intent intent1 = new Intent(TechnoActivity.this, EventListActivity.class);
			intent1.putExtra("event_list",eventList_cyber);
			intent1.putExtra("actionBarTitle",title[0]);
			startActivity(intent1);
			break;
			
		case R.id.but2:
			
			Intent intent2 = new Intent(TechnoActivity.this, EventListActivity.class);
			intent2.putExtra("event_list",eventList_sanga);
			intent2.putExtra("actionBarTitle",title[1]);
			startActivity(intent2);
			break;
			
		case R.id.but3:
			
			Intent intent3 = new Intent(TechnoActivity.this, EventListActivity.class);
			intent3.putExtra("event_list",eventList_sanga);
			intent3.putExtra("actionBarTitle",title[2]);
			startActivity(intent3);
			break;
			
		case R.id.but4:
	
			Intent intent4 = new Intent(TechnoActivity.this, EventListActivity.class);
			intent4.putExtra("event_list",eventList_sanga);
			intent4.putExtra("actionBarTitle",title[3]);
			startActivity(intent4);
			break;
	
		case R.id.but5:
			
			Intent intent5 = new Intent(TechnoActivity.this, EventListActivity.class);
			intent5.putExtra("event_list",eventList_sanga);
			intent5.putExtra("actionBarTitle",title[4]);
			startActivity(intent5);
			break;
			
		case R.id.but6:
			
			Intent intent6 = new Intent(TechnoActivity.this, EventListActivity.class);
			intent6.putExtra("event_list",eventList_sanga);
			intent6.putExtra("actionBarTitle",title[5]);
			startActivity(intent6);
			break;
			
		case R.id.but7:
			
			Intent intent7 = new Intent(TechnoActivity.this, EventListActivity.class);
			intent7.putExtra("event_list",eventList_sanga);
			intent7.putExtra("actionBarTitle",title[6]);
			startActivity(intent7);
			break;
			
		case R.id.but8:
			
			Intent intent8 = new Intent(TechnoActivity.this, EventListActivity.class);
			intent8.putExtra("event_list",eventList_sanga);
			intent8.putExtra("actionBarTitle",title[7]);
			startActivity(intent8);
			break;
	

		}
	}

}

*/