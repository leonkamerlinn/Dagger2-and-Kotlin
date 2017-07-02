package com.project.leon.daggerandkotlin.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.project.leon.daggerandkotlin.models.LocalDataModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Leon on 17.12.2015..
 */
public class LocalData extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "vinanovak.db";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DATA = "data";
    public static final String DATETIME = "datetime";
    public static final String TIMEZONE = "timezone";
    public static final String TABLE_NAME = "local_data";

    private Context mContext;


    public LocalData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }


    /*public void getTables(final ForEach each) {
        Cursor c = mRead.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        c.getCount();

        if (c.moveToFirst()) {
            while ( !c.isAfterLast() ) {
                each.onResult(c.getString(0));
                c.moveToNext();
            }
        }
    }*/

    public void delete(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?", new String[] { String.valueOf(id) });
    }

    public int update(LocalDataModel item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, item.getName());
        values.put(DATA, item.getData());
        values.put(DATETIME, item.getDateTime());
        values.put(TIMEZONE, item.getTimeZone());

        // updating row
        return db.update(TABLE_NAME, values, ID + " = ?", new String[] { String.valueOf(item.getId()) });
    }

    public LocalDataModel get(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE " + ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);

        LocalDataModel td = new LocalDataModel();


        if (c != null && c.getCount() == 1) {
            c.moveToFirst();
            td.setId(c.getInt(c.getColumnIndex(ID)));
            td.setName((c.getString(c.getColumnIndex(NAME))));
            td.setData(c.getString(c.getColumnIndex(DATA)));
            td.setDateTime(c.getString(c.getColumnIndex(DATETIME)));
            td.setTimeZone(c.getString(c.getColumnIndex(TIMEZONE)));
        }




        return td;
    }

    public long insert(LocalDataModel data) {
        ContentValues values = new ContentValues();
        values.put(NAME, data.getName());
        values.put(DATA, data.getData());
        values.put(TIMEZONE, data.getTimeZone());
        values.put(DATETIME, data.getDateTime());

        SQLiteDatabase db = this.getWritableDatabase();

        // insert row
        long data_id = db.insert(TABLE_NAME, null, values);


        return data_id;
    }

    public List<LocalDataModel> getAll() {
        List<LocalDataModel> todos = new ArrayList<LocalDataModel>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                LocalDataModel td = new LocalDataModel();
                td.setId(c.getInt((c.getColumnIndex(ID))));
                td.setName((c.getString(c.getColumnIndex(NAME))));
                td.setData(c.getString(c.getColumnIndex(DATA)));
                td.setDateTime(c.getString(c.getColumnIndex(DATETIME)));
                td.setTimeZone(c.getString(c.getColumnIndex(TIMEZONE)));

                // adding to todo list
                todos.add(td);
            } while (c.moveToNext());
        }

        return todos;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS local_data");
        }

        this.onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public interface ForEach {
        public void onResult(String item);
    }
}
