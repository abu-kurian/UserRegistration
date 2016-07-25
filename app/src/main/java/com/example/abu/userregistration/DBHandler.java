package com.example.abu.userregistration;

/**
 * Created by abu on 15/7/16.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DataBase.db";                  //database name
    public static final String TABLE_VALUES = "values";                         //name of table
    public static final String COLUMN_USN = "_USN";                             //column name
    public static final String COLUMN_isoTemplate = "_isoTemplate";             //column name

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE" + TABLE_VALUES + "(" +
                COLUMN_USN + " TEXT " +
                COLUMN_isoTemplate + " BYTE " +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE If EXISTS" + TABLE_VALUES);
        onCreate(db);

    }

    public void addProduct(DataBaseConfig dataBaseConfig){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USN,dataBaseConfig.get_isoTemplate());
        values.put(COLUMN_isoTemplate, dataBaseConfig.get_USN());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_VALUES, null, values);
        db.close();
    }

}