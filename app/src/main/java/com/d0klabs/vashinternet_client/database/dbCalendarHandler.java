package com.d0klabs.vashinternet_client.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.d0klabs.vashinternet_client.MainActivity;

import java.sql.Time;

public class dbCalendarHandler extends SQLiteOpenHelper {
    public static final String DB_NAME = "calendarVashInternet.db";
    public static final int DB_VERSION = 1;
    public static String TABLE_NAME = "testing"; //week
    public static String COL_ID = "ID";
    public static String COL_DATE = "DATE";
    public static String COL_DAYOFWEEK = "DAYOFWEEK";
    public static String COL_DESCRIPTION = "DESCRIPTION";
    public static String COL_TASK = "TASK";
    public static String COL_PLANTIMESTART = "PLANTIMESTART";
    public static String COL_PLANTIMEEND = "PLANTIMEEND";
    public static String COL_TIMESTART = "TIMESTART";
    public static String COL_TIMEEND = "TIMEEND";
    public static String COL_TOOLS = "TOOLS";
    public static String COL_TASKUPDTIME = "TASKUPDTIME";
    public static String COL_DAYPRICE = "DAYPRICE";
    public static String COL_REPAIRCOST = "REPAIRCOST";
    public static int ID = 0;
    public static String DATE;
    public static String DAYOFWEEK;
    public static String DESCRIPTION;
    public static String TASK;
    public static String PLANTIMESTART;
    public static String PLANTIMEEND;
    public static String TIMESTART;
    public static String TIMEEND;
    public static String TOOLS;
    public static String TASKUPDTIME;
    public static Integer DAYPRICE;
    public static Integer REPAIRCOST;
    public static Time currTime;



    public dbCalendarHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase calendarDBweek) {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COL_ID + " INTEGER, "
                + COL_DATE + " TEXT,"
                + COL_DAYOFWEEK + " TEXT,"
                + COL_DESCRIPTION + " TEXT,"
                + COL_TASK + " TEXT,"
                + COL_PLANTIMESTART + " TEXT,"
                + COL_PLANTIMEEND + " TEXT,"
                + COL_TIMESTART + " TEXT,"
                + COL_TIMEEND + " TEXT,"
                + COL_TOOLS + " TEXT,"
                + COL_TASKUPDTIME + " TEXT,"
                + COL_DAYPRICE + " INTEGER,"
                + COL_REPAIRCOST + " INTEGER)";
        calendarDBweek.execSQL(query);

    }

    public void setTestData_toDB() {
        DATE = "31/02/2022";
        DAYOFWEEK = "Вівторок";
        DESCRIPTION = "Зробити тестування календаря";
        TASK = " Тестування";
        PLANTIMESTART = "00:00:00";
        PLANTIMEEND = "00:00:00";
        TIMESTART = "00:00:00";
        TIMEEND = "00:00:00";
        TOOLS = "1,2,3,5";
        TASKUPDTIME = "00:00:00";
        DAYPRICE = 100;
        REPAIRCOST = 20;

        for (int i = 1; i < 10; i++) { //FOR TESTING ONLY!
            ContentValues rowfor = new ContentValues();
            rowfor.put("ID", i);
            rowfor.put("DATE", DATE);
            rowfor.put("DAYOFWEEK", DAYOFWEEK);
            rowfor.put("DESCRIPTION", DESCRIPTION);
            rowfor.put("TASK", TASK);
            rowfor.put("PLANTIMESTART", PLANTIMESTART);
            rowfor.put("PLANTIMEEND", PLANTIMEEND);
            rowfor.put("TIMESTART", TIMESTART);
            rowfor.put("TIMEEND", TIMEEND);
            rowfor.put("TOOLS", TOOLS);
            rowfor.put("TASKUPDTIME", TASKUPDTIME);
            rowfor.put("DAYPRICE", DAYPRICE);
            rowfor.put("REPAIRCOST", REPAIRCOST);
            MainActivity.dbCalendarHandler.getWritableDatabase().insert(TABLE_NAME, null, rowfor);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
