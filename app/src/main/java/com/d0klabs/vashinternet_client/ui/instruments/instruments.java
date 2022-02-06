package com.d0klabs.vashinternet_client.ui.instruments;

import android.database.Cursor;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.database.dbSkladHandler;

public class instruments {
    private String Name;

    private String ResName;

    public instruments(String Name, String ResName) {
        this.Name= Name;
        this.ResName= ResName;
    }

    public static String getName() {
        return Name;
    }

    public static String getResName() {
        return ResName;
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
}
