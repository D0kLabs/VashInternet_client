package com.d0klabs.vashinternet_client.ui.calendar;

import android.database.Cursor;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.database.dbCalendarHandler;

public class Tasks {

    public static void initTasks(){
        Cursor initList = MainActivity.dbCalendarHandler.getWritableDatabase().query(dbCalendarHandler.TABLE_NAME, new String[]{dbCalendarHandler.COL_ID},null,null,null,null,null);
        int count = initList.getCount();
        initList.moveToFirst();
        for (int i = 0; i < count; i++) {


        }

    }
}
