package com.d0klabs.vashinternet_client.ui.instruments;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;

public class InstrumentsViewHolder extends   RecyclerView.ViewHolder {

    ImageView imgView;
    TextView instrumentNameView;
    TextView instrumentPrice;
    TextView instrumentRepairCost;


    // @itemView: recyclerview_item_layout.xml
    public InstrumentsViewHolder(@NonNull View itemView) {
        super(itemView);

        this.imgView = (ImageView) itemView.findViewById(R.id.imageView);
        this.instrumentNameView = (TextView) itemView.findViewById(R.id.textView_instrumentName);
        this.instrumentPrice = (TextView) itemView.findViewById(R.id.textView_instrumentPrice);
        this.instrumentRepairCost = (TextView) itemView.findViewById(R.id.textView_instrumentRepair);

    }
}