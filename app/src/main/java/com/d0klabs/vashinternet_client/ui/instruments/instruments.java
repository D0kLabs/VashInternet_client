package com.d0klabs.vashinternet_client.ui.instruments;

import android.database.Cursor;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.database.dbInstrumentsHandler;

import static com.d0klabs.vashinternet_client.database.dbInstrumentsHandler.TableNames;

public class instruments {
    public static String[][] recyclerInstrumentsList;
    private static String Name;
    private static String ResName;
    private static int Price;
    private static int repCost;

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
    public static int getPrice(){
        return Price;
    }
    public static int getRepCost(){
        return repCost;
    }
    public static void initList() {
        for (int j = 0; j < TableNames.length; j++) {

            try (Cursor instrumentsFromDBList = MainActivity.dbInstrumentsHandler.getWritableDatabase().query(TableNames[j], new String[]{dbInstrumentsHandler.COL_INSTNAME}, null, null, null, null, null)) {
                int c = instrumentsFromDBList.getCount();
                recyclerInstrumentsList = new String[TableNames.length][c];
                instrumentsFromDBList.moveToFirst();
                for (int m=0; m < c; m++) {
                    recyclerInstrumentsList[j][m] = instrumentsFromDBList.getString(instrumentsFromDBList.getColumnIndex("INSTNAME"));
                    instrumentsFromDBList.moveToNext();
                }

                if (instrumentsFromDBList != null) instrumentsFromDBList.close();
            }
        }
    }
}
