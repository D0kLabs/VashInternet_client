package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.database.Cursor;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.database.dbSkladHandler;

import java.sql.Array;


public class Items {
    public static String[] recyclerItemList;
    public static Array aryItems;
    public static int index;
    public String buttonText;
    public Context context;
    public static android.widget.Button initButton;

    public Items(Context context) {
        //TODO: adapter impl!!!

    }

    public static void initList() {
        try (Cursor itemFromDBList = MainActivity.dbHandler.getWritableDatabase().query(dbSkladHandler.TABLE_NAME, new String[]{dbSkladHandler.COL_NAME}, null, null, null, null, null)) {
            int c = itemFromDBList.getCount();
            recyclerItemList = new String[c];
            itemFromDBList.moveToFirst();

            for (int i = 0; i < c; i++) {
                recyclerItemList[i] = itemFromDBList.getString(itemFromDBList.getColumnIndex("NAME"));
                itemFromDBList.moveToNext();
            }
            if (itemFromDBList != null) itemFromDBList.close();
        }




    }
    public static void createAndAddNewItem(Context context){

        //android.widget.Button addButton = new Button(context);
        //addButton.setText(R.string.mAddBtn);
        //index++;
        //addButton.setText("Button" + index);
        //addButton.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        //recyclerItemList.add(index, addButton);
        //SkladFragment.mAdapter.notifyItemInserted(index);

    }

    public static void incertNewButtontoEnd(Context context) {
        int insertIndex = index;
        SkladFragment.mAdapter.notifyItemInserted(insertIndex);
    }


}

