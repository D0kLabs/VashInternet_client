package com.d0klabs.vashinternet_client.ui;

import android.widget.ListAdapter;

import java.util.List;

public class ItemsBox {
    public static List<ItemsBox> recyclerList;
    public ListAdapter listAdapter;
    public androidx.recyclerview.widget.ListAdapter recyclerListAdapter;

    public static List<ItemsBox> getRecyclerList() {
        return recyclerList;
    }

    public static void setRecyclerList(List<ItemsBox> recyclerList) {
        ItemsBox.recyclerList = recyclerList;
    }


    public androidx.recyclerview.widget.ListAdapter getRecyclerListAdapter() {

        return recyclerListAdapter;
    }

    public void setRecyclerListAdapter(androidx.recyclerview.widget.ListAdapter recyclerListAdapter) {
        this.recyclerListAdapter = recyclerListAdapter;
    }


    public ItemsBox(int id, List<String> description ) {
        recyclerList.add(id, (ItemsBox) description);

    }




}
