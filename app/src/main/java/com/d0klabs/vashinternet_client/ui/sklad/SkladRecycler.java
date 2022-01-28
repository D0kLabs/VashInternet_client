package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.ui.ItemsBox;

import java.util.List;

public class SkladRecycler extends RecyclerView.Adapter<SkladRecycler.ViewHolder> {

    public static android.widget.Button zero;
    Context context;
    private final skladRecyclerPref pskladRecyclerPref;

    public SkladRecycler(List<android.widget.Button> list, Context context) {
        this.context = context;
        pskladRecyclerPref = new skladRecyclerPref(context);
        int rl;
        rl = Items.recyclerItemList.size();
        for (int i = 0; i < list.size(); i++) {
            Items.recyclerItemList.add(rl++, list.get(i));
        }
    }
    @Override
    public SkladRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sklad_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SkladRecycler.ViewHolder holder, int position) {
        //holder.first.setText((CharSequence) list.get(list.size()));

        //holder.flagView.setImageResource(state.getFlagResource());
        //holder.nameView.setText(state.getName());
       // holder.capitalView.setText(state.getCapital());
    }

    @Override
    public int getItemCount() { //WHT #! there no adapters that calculate Items, so it will work by other fx. 3 ar s ItemCount 4 ItemAdapter!
        return Items.recyclerItemList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            SkladRecycler.zero = itemView.findViewById(R.id.recyclerItem1);

        }
    }
}

