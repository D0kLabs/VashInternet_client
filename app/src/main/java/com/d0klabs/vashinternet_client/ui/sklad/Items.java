package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Items {
    public static ArrayList<Button> recyclerItemList;
    public static int index;
    public String name;

    public Items(int i, String sysname, Context context) {
        android.widget.Button addButton = new Button(context);
        addButton.setText(sysname);
        addButton.setId(i);
        index++;
        addButton.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

    }

    public static void initList(Context context){
        android.widget.Button initButton = new Button(context);
        index=0;
        initButton.setId(0);
        initButton.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

    }
}

