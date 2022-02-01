package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;

import java.sql.Array;


public class Items {
    public static String[] recyclerItemList;
    public static Array aryItems;
    public static int index;
    public String buttonText;
    public Context context;
    public static android.widget.Button initButton;

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


}

