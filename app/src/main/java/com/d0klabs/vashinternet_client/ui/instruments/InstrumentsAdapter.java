package com.d0klabs.vashinternet_client.ui.instruments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.ui.sklad.ItemTouchHelperCallback;

public class InstrumentsAdapter extends RecyclerView.Adapter<InstrumentsViewHolder> implements ItemTouchHelperCallback.ItemTouchHelperAdapter {
    //TODO: for tabs and tabI++ !!! DO IMPL !!!

    private int imagResId;
    private Context context;
    private LayoutInflater mLayoutInflater;
    public int tab = instrumentsFragment.tabs.getTabCount();
    public static int lenth = 0;
    public InstrumentsAdapter(Context context) {
        this.context = context;
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
        //imagResId = this.getDrawableResIdByName(instruments.getResName());
            holder.imgView.setImageResource(imagResId);
            holder.instrumentNameView.setText(instruments.getName(tab, position));
            holder.instrumentPrice.setText(instruments.getPrice(tab, position));
            holder.instrumentRepairCost.setText(instruments.getRepCost(tab, position));

    }

    @Override
    public int getItemCount() {
        // перевірити які вюшки пусті і рахувати тільки заповнені
        return lenth;
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
        //Toast.makeText(this.context, instruments.getName(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemDismiss(int position) {

    }
}