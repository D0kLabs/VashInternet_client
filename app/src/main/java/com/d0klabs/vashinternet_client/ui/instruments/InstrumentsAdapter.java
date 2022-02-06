package com.d0klabs.vashinternet_client.ui.instruments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.ui.sklad.ItemTouchHelperCallback;

import java.util.List;

public class InstrumentsAdapter extends RecyclerView.Adapter<InstrumentsViewHolder> implements ItemTouchHelperCallback.ItemTouchHelperAdapter {
    //TODO: for tabs and tabI++ !!! DO IMPL !!!

    private List<instruments> instrumentsList;
    private int imagResId;
    private Context context;
    private LayoutInflater mLayoutInflater;
    public InstrumentsAdapter(Context context, List<instruments> datas ) {
        this.context = context;
        this.instrumentsList = datas;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public InstrumentsViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // Inflate view from recyclerview_item_layout.xml
        View recyclerViewItem = mLayoutInflater.inflate(R.layout.recyclerview_item_layout, parent, false);

        recyclerViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRecyclerItemClick( (RecyclerView)parent, v);
            }
        });
        return new InstrumentsViewHolder(recyclerViewItem);
    }


    @Override
    public void onBindViewHolder(InstrumentsViewHolder holder, int position) {
        imagResId = this.getDrawableResIdByName(instruments.getResName());
        holder.flagView.setImageResource(imagResId);
        holder.instrumentNameView.setText(instruments.getName());
    }

    @Override
    public int getItemCount() {
        return this.instrumentsList.size();
    }

    // Find Image ID corresponding to the name of the image (in the directory drawable).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        return resID;
    }

    // Click on RecyclerView Item.
    private void handleRecyclerItemClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        // something todo on click! Maybe load other layout with it settings
        Toast.makeText(this.context, instruments.getName(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemDismiss(int position) {

    }
}