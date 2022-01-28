package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;

public class SkladRecycler extends RecyclerView.Adapter<SkladRecycler.ViewHolder> {

    private final Context context;
    //ArrayList<Itm> receclerItems = new ArrayList<Itm>();

    public SkladRecycler(Context context) {
        this.context = context;
    }
    @Override
    public SkladRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sklad_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SkladRecycler.ViewHolder holder, int position) {

        //holder.flagView.setImageResource(state.getFlagResource());
        //holder.nameView.setText(state.getName());
       // holder.capitalView.setText(state.getCapital());
    }

    @Override
    public int getItemCount() { //WHT #! there no adapters that calculate Items, so it will work by other fx. 3 ar s ItemCount 4 ItemAdapter!
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button first;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            first = itemView.findViewById(R.id.recyclerItem1);

        }
    }
}

