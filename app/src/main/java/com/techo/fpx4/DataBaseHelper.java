package com.techo.fpx4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DataBaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "Footprints X4";
    // private static final String TABLE_NAME = "Cybernetics";
    private static final int DATABASE_VERSION = 1;
    private static final String EVENT_NAME = "event_name";
    private SQLiteDatabase myDatabase;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public synchronized void close() {
        if (myDatabase != null)
            myDatabase.close();
        super.close();

    }


    public Cursor getAnEvent(String[] event_name_fetched, String DEPT_NAME) {
        myDatabase = this.getReadableDatabase();
        Cursor c = myDatabase.rawQuery("SELECT * FROM " + DEPT_NAME + " WHERE " + EVENT_NAME + " = ?", event_name_fetched);
        return c;
    }


    public Cursor getEventList(String TABLENAME) {
        myDatabase = this.getReadableDatabase();
        Cursor c = myDatabase.query(TABLENAME, null, null, null, null, null, null);
        return c;
    }


}
