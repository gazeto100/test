package com.example.adefault.budjet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by default on 5/15/18.
 */

public class Databasehepler extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Smetki.db";
    public static final String TABLE_NAME = "smetki_table";
    public static final String ID = "ID";
    public static final String DATA = "DATA";
    public static final String SUMA = "SUMA";
    public static final String WHAT = "WHAT";

    public Databasehepler(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,DATA TEXT, SUMA DOUBLE, WHAT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IT EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String data, String what, String suma){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATA, data);
        contentValues.put(SUMA, suma);
        contentValues.put(WHAT, what);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }else{
            return true;
        }
    }
}
