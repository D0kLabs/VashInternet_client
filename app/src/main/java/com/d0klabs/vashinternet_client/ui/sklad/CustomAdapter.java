package com.d0klabs.vashinternet_client.ui.sklad;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements ItemTouchHelperCallback.ItemTouchHelperAdapter {
    private static final String TAG = "CustomAdapter";
    public static final int TITLE = 0;
    public static final int LOAD_MORE = 1;
    public static Button[] buttons;
    private boolean hasLoadButton = true;

    public static final int HEADER = 1;
    private static final int ITEM = 2;

    @Override
    public void onItemDismiss(int position) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView;
        }
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == TITLE) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.recycler_item_list, viewGroup, false);

            return new ViewHolder(v);
        } else if (viewType == LOAD_MORE) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.recycler_item_list_more, viewGroup, false);
            return new ViewHolder(v);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder viewHolder, int position) {
        Log.d(TAG, "Element " + position + " set.");

            viewHolder.text.setText(Items.recyclerItemList[position]);
    }


    public boolean isHasLoadButton() {
        return hasLoadButton;
    }

    public void setHasLoadButton(boolean hasLoadButton) {
        this.hasLoadButton = hasLoadButton;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
/*
        if (hasLoadButton) {
            return buttons.length; //+1
        } else {
            return buttons.length;
        }

 */
        return Items.recyclerItemList.length;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < getItemCount()) {
            return TITLE;
        } else {
            return LOAD_MORE;
        }
    }
}