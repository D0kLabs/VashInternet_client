package com.d0klabs.vashinternet_client.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Time;

public class dbCalendarHandler extends SQLiteOpenHelper {
    public static final String DB_NAME = "calendarVashInternet.db";
    public static final int DB_VERSION = 1;
    public static String TABLE_NAME; //week
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
    public static String TIMESTART;
    public static String TIMEEND;
    public static String TOOLS;
    public static String TASKUPDTIME;
    public static Integer DAYPRICE;
    public static Integer REPAIRCOST;
    public static Time currTime;



    public dbCalendarHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
