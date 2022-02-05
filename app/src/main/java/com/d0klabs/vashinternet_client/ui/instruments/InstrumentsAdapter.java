package com.d0klabs.vashinternet_client.ui.instruments;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.ui.sklad.ItemTouchHelperCallback;

import org.jetbrains.annotations.NotNull;

public class InstrumentsAdapter extends RecyclerView.Adapter implements ItemTouchHelperCallback.ItemTouchHelperAdapter {
    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onItemDismiss(int position) {

    }
}
