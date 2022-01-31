package com.d0klabs.vashinternet_client.ui.sklad;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";
    public static final int TITLE = 0;
    public static final int LOAD_MORE = 1;
    public static Button[] buttons;
    private boolean hasLoadButton = true;


    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static android.widget.Button recycleButton;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            recycleButton = (Button) v.findViewById(R.id.recyclerItem0);
        }

        public Button getRecycleButton(){
            return recycleButton;
        }

    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet Button[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapter(Button[] dataSet) {
        buttons = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
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
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        //viewHolder.getLinearLayout().setId(Items.recyclerItemList.get(position).getId());
        //if (position >= getItemCount()){
            //load more)

        //} else {
            viewHolder.setIsRecyclable(true);
            viewHolder.getRecycleButton();
        //}

        //viewHolder.itemView.setId(Items.recyclerItemList.get(position).getId());


                //setText(mDataSet[position]);
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)

    public boolean isHasLoadButton() {
        return hasLoadButton;
    }

    public void setHasLoadButton(boolean hasLoadButton) {
        this.hasLoadButton = hasLoadButton;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        if (hasLoadButton) {
            return buttons.length +1; //+1
        } else {
            return buttons.length;
        }

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