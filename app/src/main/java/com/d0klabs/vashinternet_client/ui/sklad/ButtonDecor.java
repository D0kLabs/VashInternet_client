package com.d0klabs.vashinternet_client.ui.sklad;

import android.graphics.Canvas;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ButtonDecor extends RecyclerView.ItemDecoration {

    public ButtonDecor() {

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        for (int i = 0; i < parent.getChildCount(); i++) {
            View view = parent.getChildAt(i);

            if (parent.getChildAdapterPosition(view) == 22) {
                int offset = view.getTop() / 3;

            }
        }

    }

}