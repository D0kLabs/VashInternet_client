package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.d0klabs.vashinternet_client.R;

public class SkladRecycler extends RecyclerView.Adapter<SkladRecycler.ViewHolder> {

    private final LayoutInflater inflater;

    public SkladRecycler(Context context) {
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public SkladRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.sklad_items, parent, false);
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
        //final ImageView flagView;
        //final TextView nameView, capitalView;
       public ViewHolder(View view){
            super(view);
            //flagView = view.findViewById(R.id.flag);
           // nameView = view.findViewById(R.id.name);
            //capitalView = view.findViewById(R.id.capital);
        }
    }
}
