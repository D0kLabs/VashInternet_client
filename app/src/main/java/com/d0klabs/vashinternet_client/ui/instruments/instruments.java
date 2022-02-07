package com.d0klabs.vashinternet_client.ui.instruments;

import android.database.Cursor;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.database.dbInstrumentsHandler;

import java.util.List;

import static com.d0klabs.vashinternet_client.database.dbInstrumentsHandler.TableNames;

public class instruments {
    public static String[][] recyclerInstrumentsList;
    private static String Name;
    private static String ResName;
    private static String Descr;
    private static int Price;
    private static int repCost;

    public instruments(String Name) {
        this.Name= Name;
        this.ResName= ResName;
    }

    public instruments(String name, String descr, int price, int repCost) {
        setName(name);
        setDescription(descr);
        setPrice(price);
        setRepCost(repCost);
    }

    public static String getName(int tab, int pos) {
        Name = instrumentsFragment.instrumentsList[tab][pos].get(0).toString();
        return Name;
    }

    public static String getResName() {
        return ResName;
    }
    public static int getPrice(int tab, int pos){
        Price = (int) instrumentsFragment.instrumentsList[tab][pos].get(2);
        return Price;
    }
    public static int getRepCost(int tab, int pos){
        repCost = (int) instrumentsFragment.instrumentsList[tab][pos].get(3);
        return repCost;
    }
    public static void setName(String name){
        Name = name;
    }
    public static void setDescription(String descr){
        Descr = descr;
    }
    public static void setPrice(int price){
        Price = price;
    }
    public static void setRepCost(int repcost){
        repCost = repcost;
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
    public static List[][] updateInfoFromList(){
        for (int u = 0; u < TableNames.length; u++) {
            Cursor instrumentsInfoFromDB = MainActivity.dbInstrumentsHandler.getWritableDatabase().rawQuery("SELECT * FROM " + TableNames[u], null);
            instrumentsInfoFromDB.moveToFirst();
            int count = instrumentsInfoFromDB.getCount();
            for (int i = 0; i < count; i++) {
                Name = instrumentsInfoFromDB.getString(1);
                Descr = instrumentsInfoFromDB.getString(2);
                Price = instrumentsInfoFromDB.getInt(6);
                repCost = instrumentsInfoFromDB.getInt(7);
                instrumentsInfoFromDB.moveToNext();

                instrumentsFragment.instrumentsList[u][i] = (List) new instruments(Name, Descr, Price, repCost);
            }
            if (instrumentsInfoFromDB != null) instrumentsInfoFromDB.close();
        }
        return instrumentsFragment.instrumentsList;
    }
}
