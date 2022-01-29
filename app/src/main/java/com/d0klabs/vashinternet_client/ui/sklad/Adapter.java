package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.d0klabs.vashinternet_client.ui.sklad.SkladFragment.skladFragmentBinding;
import static com.d0klabs.vashinternet_client.ui.sklad.SkladFragment.skladRecycleLayoutManager;
import static com.d0klabs.vashinternet_client.ui.sklad.SkladFragment.viewHolder;

public class Adapter extends androidx.recyclerview.widget.RecyclerView.Adapter {

    private ArrayList<Button> mAdapter;
    public Adapter (ArrayList<Button> mArrayList){
        mAdapter = mArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View fragmentView = LayoutInflater.from(context).inflate(R.layout.recycler_item_list, parent, false);
        //viewHolder = new SkladFragment.itemHolder(fragmentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        skladRecycleLayoutManager = new RecyclerView.LayoutManager() {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return null;
            }
        };
        View v = skladRecycleLayoutManager.findViewByPosition(position);
        skladFragmentBinding.skladRecyclerView.setLayoutManager(skladRecycleLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                skladFragmentBinding.skladRecyclerView.getContext(), SkladFragment.layoutManager.getOrientation()
        );
        skladFragmentBinding.skladRecyclerView.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public int getItemCount() {
        if (Items.recyclerItemList != null){
            return Items.recyclerItemList.size();
        } else return 0;
    }
}
