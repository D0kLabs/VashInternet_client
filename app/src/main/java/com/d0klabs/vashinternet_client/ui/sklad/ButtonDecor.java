package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;

public class ButtonDecor extends RecyclerView.ItemDecoration {

    private Bitmap mImage;

    public ButtonDecor(final Context context, @DrawableRes int resId) {
        mImage = BitmapFactory.decodeResource(context.getResources(), resId);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        for (int i = 0; i < parent.getChildCount(); i++) {
            View view = parent.getChildAt(i);
            if (parent.getChildAdapterPosition(view) == 22) {
                int offset = view.getTop() / 3;
                c.drawBitmap(mImage, new Rect(0, offset, mImage.getWidth(), view.getHeight() + offset),
                        new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()), null);
            }
        }

    }
}