package com.d0klabs.vashinternet_client.ui;

import android.widget.ListAdapter;

public class ItemsBox {
    public ListAdapter listAdapter;
    public androidx.recyclerview.widget.ListAdapter recyclerListAdapter;

    public androidx.recyclerview.widget.ListAdapter getRecyclerListAdapter() {

        return recyclerListAdapter;
    }

    public void setRecyclerListAdapter(androidx.recyclerview.widget.ListAdapter recyclerListAdapter) {
        this.recyclerListAdapter = recyclerListAdapter;
    }


    public ItemsBox(ListAdapter listAdapter) {
        this.listAdapter = listAdapter;
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }

    public void setListAdapter(ListAdapter listAdapter) {
        this.listAdapter = listAdapter;
    }





}
