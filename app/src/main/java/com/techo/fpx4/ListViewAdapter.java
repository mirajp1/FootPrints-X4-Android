package com.techo.fpx4;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<String> listTitleList;
    private ArrayList<Integer> leftIconList;
    private ArrayList<String> listDescription;
    private ArrayList<String> etc;                //dummy string to implemnet a pure virtual function.
    int x;
    ArrayList<Integer> leftIcon;


    public ListViewAdapter(Activity activity, ArrayList<String> listTitleList, ArrayList<Integer> leftIconList, ArrayList<String> listDescription) {
        super();
        this.listTitleList = listTitleList;
        this.activity = activity;
        this.leftIconList = leftIconList;
        this.listDescription = listDescription;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return leftIconList.size();
    }

    @Override
    public String getItem(int position) {
        // TODO Auto-generated method stub
        return etc.get(position);
    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder {
        public ImageView viewHolderLeftIcon;
        public TextView viewHolderListTitle;
        public TextView viewHolderListDescription;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();

        if (convertView == null) {
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.layout_listview_item, null);

            view.viewHolderListTitle = (TextView) convertView.findViewById(R.id.listTitle);        //inflate the name textview
            view.viewHolderLeftIcon = (ImageView) convertView.findViewById(R.id.leftIcon);    //inlfate the icon imageview


            view.viewHolderListDescription = (TextView) convertView.findViewById(R.id.listDescription);    //set the department textview if the first value in the buttonDeptList is not zero.


            convertView.setTag(view);
        } else {
            view = (ViewHolder) convertView.getTag();
        }

        //set the values in textviews and imageviews

        view.viewHolderListTitle.setText(listTitleList.get(position));
        view.viewHolderLeftIcon.setImageResource(leftIconList.get(position));
        view.viewHolderListDescription.setText(listDescription.get(position));

        return convertView;
    }


}
