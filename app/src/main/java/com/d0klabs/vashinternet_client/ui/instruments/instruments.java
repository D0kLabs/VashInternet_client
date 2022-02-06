package com.d0klabs.vashinternet_client.ui.instruments;

import android.database.Cursor;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.database.dbInstrumentsHandler;

public class instruments {
    public static String[] recyclerInstrumentsList;
    private static String Name;

    private static String ResName;

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
        try (Cursor instrumentsFromDBList = MainActivity.dbInstrumentsHandler.getWritableDatabase().query(dbInstrumentsHandler.TABLE_NAME, new String[]{dbInstrumentsHandler.COL_INSTNAME}, null, null, null, null, null)) {
            int c = instrumentsFromDBList.getCount();
            recyclerInstrumentsList = new String[c];
            instrumentsFromDBList.moveToFirst();

            for (int i = 0; i < c; i++) {
                recyclerInstrumentsList[i] = instrumentsFromDBList.getString(instrumentsFromDBList.getColumnIndex("INSTNAME"));
                instrumentsFromDBList.moveToNext();
            }
            if (instrumentsFromDBList != null) instrumentsFromDBList.close();
        }
    }
}
