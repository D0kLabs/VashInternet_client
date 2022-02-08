package com.d0klabs.vashinternet_client.ui.instruments;

import android.database.Cursor;

import com.d0klabs.vashinternet_client.MainActivity;

import static com.d0klabs.vashinternet_client.database.dbInstrumentsHandler.TableNames;

public class instruments {
    private static String Name;
    private static String ResName;
    private static String Descr;
    private static Integer Price;
    private static Integer repCost;

    public instruments(String Name) {
        this.Name= Name;
        this.ResName= ResName;
    }

    public instruments(String name, String descr, int price, int repCost) {

    }

    public static String getName(int tab, int pos) {
        Name = instrumentsFragment.recyclerInstrumentsList[tab][pos];
        return Name;
    }

    public static String getResName() {
        return ResName;
    }
    public static int getPrice(int tab, int pos){
        Price = Integer.valueOf(instrumentsFragment.recyclerPriceList[tab][pos]);
        return Price;
    }
    public static int getRepCost(int tab, int pos){
        repCost = instrumentsFragment.recyclerRepCostList[tab][pos];
        return repCost;
    }
    public static void setName(String name, int tab, int pos){
        instrumentsFragment.recyclerInstrumentsList[tab][pos] = name;
        Name = name;
    }
    public static void setDescription(String descr, int tab, int pos){
        Descr = descr;
    }
    public static void setPrice(Integer price, int tab, int pos){
        instrumentsFragment.recyclerPriceList[tab][pos] = Integer.valueOf(price);
    }
    public static void setRepCost(Integer repcost, int tab, int pos){
        instrumentsFragment.recyclerRepCostList[tab][pos] = repcost;
    }

    public static void updateInfoFromList(){
        for (int u = 0; u < TableNames.length; u++) {
            Cursor instrumentsInfoFromDB = MainActivity.dbInstrumentsHandler.getWritableDatabase().rawQuery("SELECT * FROM " + TableNames[u], null);
            int count = instrumentsInfoFromDB.getCount();
            InstrumentsAdapter.lenth = (TableNames.length * count);
            instrumentsFragment.recyclerInstrumentsList = new String[TableNames.length][count];
            instrumentsFragment.recyclerPriceList = new Integer[TableNames.length][count];
            instrumentsFragment.recyclerRepCostList = new Integer[TableNames.length][count];
            instrumentsInfoFromDB.moveToFirst();
            for (int i = 0; i < count; i++) {
                instrumentsFragment.recyclerInstrumentsList[u][i] = instrumentsInfoFromDB.getString(instrumentsInfoFromDB.getColumnIndex("INSTNAME"));
                instrumentsFragment.recyclerPriceList[u][i] = instrumentsInfoFromDB.getInt(instrumentsInfoFromDB.getColumnIndex("PRICE"));
                instrumentsFragment.recyclerRepCostList[u][i] = instrumentsInfoFromDB.getInt(instrumentsInfoFromDB.getColumnIndex("REPCOST"));
                instrumentsInfoFromDB.moveToNext();
            }
            if (instrumentsInfoFromDB != null) instrumentsInfoFromDB.close();
        }
    }
}
