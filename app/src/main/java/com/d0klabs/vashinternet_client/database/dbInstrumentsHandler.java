package com.d0klabs.vashinternet_client.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.d0klabs.vashinternet_client.MainActivity;

import java.sql.Time;
import java.util.Date;

public class dbInstrumentsHandler extends SQLiteOpenHelper {
    public static final String DB_NAME = "instrumentsVashInternet.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "tab";
    public static String COL_ID = "ID"; //index of itemList
    public static String COL_INSTNAME = "INSTNAME"; //text for button
    public static String COL_DESCRIPTION = "DESCRIPTION"; // text for inside view
    public static String COL_CRTIN = "CRTIN"; // time of input
    public static String COL_CRTLUPD = "CRTLUPD"; // time of expiration (00:00 if none)
    public static String COL_INPUTIN = "INPUTIN"; // time of adding to sql
    public static String COL_PRICE = "PRICE";
    public static String COL_REPCOST = "REPCOST";
    public static int ID = 0;
    public static String INSTNAME;
    public static String DESCRIPTION;
    public static Time currTime;
    public static String CRTIN;
    public static String CRTLUPD;
    public static String INPUTIN;
    public static Integer PRICE;
    public static Integer REPCOST;


    public dbInstrumentsHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public static String TableNames[] = { new String("TAB1"), new String("TAB2"), new String("TAB3"), new String("TAB4") };



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (int i = 0; i < TableNames.length; i++) {
            String query = "CREATE TABLE " + TableNames[i]
                    + " (" + COL_ID + " INTEGER, "
                    + COL_INSTNAME + " TEXT,"
                    + COL_DESCRIPTION + " TEXT,"
                    + COL_CRTIN + " TEXT,"
                    + COL_CRTLUPD + " TEXT,"
                    + COL_INPUTIN + " TEXT,"
                    + COL_PRICE + " INTEGER,"
                    + COL_REPCOST + " INTEGER)";
            sqLiteDatabase.execSQL(query);
        }

    }

    public void setTestData_toDB(){
        INSTNAME = "zeroinstrument";
        DESCRIPTION = "none";
        Time currTime = new Time(0L);
        currTime.setTime(new Date().getTime());
        CRTIN = currTime.toString();
        CRTLUPD = "00:00:00";
        INPUTIN = "00:00:00";
        PRICE = 0;
        REPCOST = 0;

        for (int j = 0; j < TableNames.length; j++) {
            for (int i = 1; i < 10; i++) { //FOR TESTING ONLY!
                ContentValues rowfor = new ContentValues();
                rowfor.put("ID", i);
                rowfor.put("INSTNAME", INSTNAME);
                rowfor.put("DESCRIPTION", DESCRIPTION);
                rowfor.put("CRTIN", CRTIN);
                rowfor.put("CRTLUPD", CRTLUPD);
                rowfor.put("INPUTIN", CRTIN);
                rowfor.put("PRICE", PRICE);
                rowfor.put("REPCOST", REPCOST);
                MainActivity.dbInstrumentsHandler.getWritableDatabase().insert(TableNames[j], null, rowfor);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for (int m= 0; m < TableNames.length; m++) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TableNames[m]);
        }

    }
}
