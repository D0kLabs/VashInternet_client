package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.d0klabs.vashinternet_client.MainActivity;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;

public class Items {
    public static String[] recyclerItemList;
    public static Array aryItems;
    public static int index;
    public String buttonText;
    public Context context;
    public static android.widget.Button initButton;
    /**
     * ONLY FOR SQL USING
     */
    public static int idex; //index of itemList
    public static String name; //text for button
    public static String description; // text for inside view
    public static java.sql.Time crtIN; // time of input at @sklad
    public static java.sql.Time crtEXPR; // time of expiration (00:00 if none) TODO: test time 00:00
    public static java.sql.Time inputIN; // time of adding to sql
    /**
     * END SQL USING
     */

    public Items(Context context) {
        recyclerItemList = new String[60];
        //TODO: adapter impl!!!

    }

    public static void initList(){
        recyclerItemList = new String[60];
        recyclerItemList[0] = "zero button";
        for (int i = 1; i < recyclerItemList.length; i++) {
            recyclerItemList[i] = String.valueOf("Найменування " + i);
        }

    }
    public static void createAndAddNewItem(Context context){

        //android.widget.Button addButton = new Button(context);
        //addButton.setText(R.string.mAddBtn);
        //index++;
        //addButton.setText("Button" + index);
        //addButton.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        //recyclerItemList.add(index, addButton);
        //SkladFragment.mAdapter.notifyItemInserted(index);

    }

    public static void incertNewButtontoEnd(Context context) {
        int insertIndex = index;
        SkladFragment.mAdapter.notifyItemInserted(insertIndex);
    }

    public static void initmyDB(){
        ContentValues row1 = new ContentValues();
        crtIN = new Time(0L);
        crtIN.setTime(new java.util.Date().getTime()); //current time as some to init crtIN
        crtEXPR = new Time(0L);
        crtEXPR.setTime(new java.util.Date().getTime());
        inputIN = new Time(0L);
        inputIN.setTime(new java.util.Date().getTime());
        row1.put("idex", 0);
        row1.put("name", "zero_button");
        row1.put("description","There are no description found. Please call CHIEF");
        row1.put("crtIN", String.valueOf(crtIN));
        row1.put("crtEXPR", String.valueOf(crtEXPR));
        row1.put("inputIN", String.valueOf(inputIN));
        MainActivity.myDB.insert("itemsVashInternet.db",null, row1);
    }

}

