package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.d0klabs.vashinternet_client.MainActivity;

import java.util.ArrayList;

public class Items {
    public static ArrayList<Button> recyclerItemList;
    public static ArrayAdapter recyclerItemAdapter;
    public static int index;
    public String name;
    public Context context;
    public static android.widget.Button initButton;

    public Items(Context context) {
        recyclerItemList = new ArrayList<Button>();
        //TODO: adapter impl!!!

    }

    public static void initList(){
        initButton = MainActivity.zero;
        index=0;
        recyclerItemList.add(0,initButton);

    }
    public static void createAndAddNewButton(Context context){

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

