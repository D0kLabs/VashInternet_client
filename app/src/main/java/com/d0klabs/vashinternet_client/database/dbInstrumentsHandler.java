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
    public static String COL_REPR = "REPR"; // number of usage to expire
    public static String COL_CRTLUPD = "CRTLUPD"; // time of expiration (00:00 if none)
    public static String COL_INPUTIN = "INPUTIN"; // time of adding to sql
    public static int ID = 0;
    public static String INSTNAME;
    public static String DESCRIPTION;
    public static Time currTime;
    public static String CRTIN;
    public static int REPR = 0;
    public static String CRTLUPD;
    public static String INPUTIN;
    public static int tabCount = 4;

    public dbInstrumentsHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (int i = 0; i < tabCount; i++) {
            String tablename = TABLE_NAME + i;
            String query = "CREATE TABLE " + tablename
                    + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_INSTNAME + " TEXT,"
                    + COL_DESCRIPTION + " TEXT,"
                    + COL_CRTIN + " TEXT,"
                    + COL_REPR + "INTEGER,"
                    + COL_CRTLUPD + " TEXT,"
                    + COL_INPUTIN + " TEXT)";
            sqLiteDatabase.execSQL(query);
        }

    }

    public void setTestData_toDB(){
        INSTNAME = "zeroinstrument";
        DESCRIPTION = "none";
        Time currTime = new Time(0L);
        currTime.setTime(new Date().getTime());
        CRTIN = currTime.toString();
        REPR = 0;
        CRTLUPD = "00:00:00";
        INPUTIN = "00:00:00";

        for (int j = 0; j < tabCount; j++) {
            String tablename = TABLE_NAME + j;
            for (int i = 1; i < 10; i++) { //FOR TESTING ONLY!
                ContentValues rowfor = new ContentValues();
                rowfor.put("ID", j);
                rowfor.put("INSTNAME", "instrument" + j);
                rowfor.put("DESCRIPTION", DESCRIPTION);
                rowfor.put("CRTIN", CRTIN);
                rowfor.put("REPR", REPR);
                rowfor.put("CRTLUPD", CRTLUPD);
                rowfor.put("INPUTIN", CRTIN);
                MainActivity.dbInstrumentsHandler.getWritableDatabase().insert(tablename, null, rowfor);
                MainActivity.dbInstrumentsHandler.close();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for (int m= 0; m < tabCount; m++) {
            String tablename = TABLE_NAME + m;
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tablename);
        }

    }
}
