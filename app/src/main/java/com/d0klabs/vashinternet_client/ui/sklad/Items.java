package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;

import java.util.ArrayList;

public class Items {
    public static ArrayList<Button> recyclerItemList;
    public static int index;
    public String name;
    public Context context;
    public static android.widget.Button initButton;

    public Items(String sysname, Context context) {
        recyclerItemList = new ArrayList<Button>();

    }

    public static Button initList(Context context){
        initButton = new Button(context);
        index=0;
        initButton.setId(R.id.recyclerItem0);
        initButton.setText(R.string.t0button);
        initButton.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        initButton.setEnabled(true);

        recyclerItemList = new ArrayList<Button>();
        recyclerItemList.add(initButton); //<
        return initButton;

    }
    public static void createAndAddNewButton(Context context){
        android.widget.Button addButton = initList(context);
        addButton.setId(Button.generateViewId());
        addButton.setText(R.string.mAddBtn);
        index++;
        addButton.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        recyclerItemList.add(index, addButton);
        SkladFragment.mAdapter.notifyItemInserted(index);

    }

    public static void incertNewButtontoEnd(Context context) {
        int insertIndex = index;
        SkladFragment.mAdapter.notifyItemInserted(insertIndex);
    }
}

