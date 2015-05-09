package com.techo.fpx4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;

public class OldEventListActivity extends SherlockActivity {

    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_eventlist);
        final String[] event_list = getIntent().getExtras().getStringArray("event_list");

        String actionBarTitle = getIntent().getExtras().getString("actionBarTitle");
        setTitle(actionBarTitle);

        listview = (ListView) findViewById(R.id.listview);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layout_listview_item, R.id.listTitle, event_list);

        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                //String itemValue=(String)listview.getItemAtPosition(position);

                switch (itemPosition) {
                    case 0:
                        Intent intent0 = new Intent(OldEventListActivity.this, EventActivity.class);
                        intent0.putExtra("actionBarTitle", event_list[0]);
                        startActivity(intent0);
                        break;


                    case 1:
                        Intent intent1 = new Intent(OldEventListActivity.this, EventActivity.class);
                        intent1.putExtra("actionBarTitle", event_list[1]);
                        startActivity(intent1);
                        break;


                    case 2:
                        Intent intent2 = new Intent(OldEventListActivity.this, EventActivity.class);
                        intent2.putExtra("actionBarTitle", event_list[2]);
                        startActivity(intent2);
                        break;


                    case 3:
                        Intent intent3 = new Intent(OldEventListActivity.this, EventActivity.class);
                        intent3.putExtra("actionBarTitle", event_list[3]);
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(OldEventListActivity.this, EventActivity.class);
                        intent4.putExtra("actionBarTitle", event_list[4]);
                        startActivity(intent4);
                        break;

                }
            }
        });


    }

}


	


