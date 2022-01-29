package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.R;

import java.util.List;

public class SkladRecycler extends RecyclerView.Adapter<SkladRecycler.ViewHolder> {


    Context context;

    public SkladRecycler(List<android.widget.Button> list, Context context) {
        this.context = context;
        int rl;
        rl = Items.recyclerItemList.size();
        for (int i = 0; i < list.size(); i++) {
            Items.recyclerItemList.add(rl++, list.get(i));
        }
    }
    @Override
    public SkladRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent);
        //View view = SkladFragment.skladFragmentBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new SkladRecycler.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SkladRecycler.ViewHolder holder, int position) {
        holder.setIsRecyclable(true);
        holder.itemView.setEnabled(true);
        holder.itemView.setMinimumHeight(30);
        holder.itemView.setMinimumWidth(30);
        //holder.first.setText((CharSequence) list.get(list.size()));
        //holder.flagView.setImageResource(state.getFlagResource());
        //holder.nameView.setText(state.getName());
       // holder.capitalView.setText(state.getCapital());
    }

    @Override
    public int getItemCount() {
        if (Items.recyclerItemList != null){
            return Items.recyclerItemList.size();
        } else return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            MainActivity.zero = itemView.findViewById(R.id.recyclerItem0); // Поміняти... щось тут не те

        }
    }
}

