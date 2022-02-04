package com.d0klabs.vashinternet_client.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.d0klabs.vashinternet_client.MainActivity;

import java.sql.Time;
import java.util.Date;

public class dbSkladHandler extends SQLiteOpenHelper {

    public static final String DB_PATH = "/data/data/com.d0klabs.vashinternet_client/databases/";
    public static final String DB_PATH2 = "/data/user/0/com.d0klabs.vashinternet_client/databases/";

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "itemsVashInternet.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "itemsVI";


    //public static SQLiteDatabase itemsVI = null;


    // creating a constructor for our database handler.
    public dbSkladHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    /**
     * ONLY FOR SQL USING
     *
     * В SQLite применяется следующая система типов данных:
     *
     * INTEGER: представляет целое число, аналог типу int в java
     *
     * REAL: представляет число с плавающей точкой, аналог float и double в java
     *
     * TEXT: представляет набор символов, аналог String и char в java
     *
     * BLOB: представляет массив бинарных данных, например, изображение, аналог типу int в java
     *
     * Сохраняемые данные должны представлять соответствующие типы в java.
     *
     */
    //START OF SQL USING
    public static String COL_IDEX = "IDEX"; //index of itemList
    public static String COL_NAME = "NAME"; //text for button
    public static String COL_DESCRIPTION = "DESCRIPTION"; // text for inside view
    public static String COL_CRTIN = "CRTIN"; // time of input at @sklad
    public static String COL_CRTEXPR = "CRTEXPR"; // time of expiration (00:00 if none) TODO: test time 00:00
    public static String COL_INPUTIN = "INPUTIN"; // time of adding to sql
    public static int IDEX = 0;
    public static String NAME;
    public static String DESCRIPTION;
    public static Time currTime;
    public static String CRTIN;
    public static String CRTEXPR;
    public static String INPUTIN;
    // END SQL USING

    @Override
    public void onCreate(SQLiteDatabase itemsVI) {

        String q = "CREATE TABLE " + TABLE_NAME
                    + " (" + COL_IDEX + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT,"
                    + COL_DESCRIPTION + " TEXT,"
                    + COL_CRTIN + " TEXT,"
                    + COL_CRTEXPR + " TEXT,"
                    + COL_INPUTIN + " TEXT)";
        itemsVI.execSQL(q);

    }

    public boolean checkDataBase(){

        SQLiteDatabase itemsVI = this.getWritableDatabase();

        try{
            String myPath = DB_PATH + DB_NAME;
            itemsVI = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

        }catch(SQLiteException e){


        }

        if(itemsVI == null){

            try{
                String mPath = DB_PATH2 +DB_NAME;
                itemsVI = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.OPEN_READWRITE);
            } catch(SQLiteException e){
        }
            itemsVI.close();
        }
        return itemsVI != null ? false : true;
    }

    public boolean checkDataBaseTable(){
        boolean clear = true;
        String[] col= { "IDEX" };
        //IDEX = "0";
        SQLiteDatabase itemsVI = MainActivity.dbHandler.getWritableDatabase();
        Cursor clearCheck = itemsVI.query(TABLE_NAME, col, null, null, null, null, null);
        if (!(clearCheck.moveToFirst()) || clearCheck.getCount() ==0) {
            for (int i = 1; i < clearCheck.getColumnCount(); i++) { //для SQLite3 перше _rowid_ це 1 а не 0
                if (clearCheck.getInt(i) == 0) {
                    clear = false;
                }
            }
        }
            clearCheck.close();

        return clear;
    }


    public void initItemsVI() {
        SQLiteDatabase itemsVI = MainActivity.dbHandler.getWritableDatabase();
        ContentValues row1 = new ContentValues();
        //IDEX = "0";
        NAME = "zerobutton";
        DESCRIPTION = "Therearenodescriptionfound.PleasecallCHIEF";
        Time currTime = new Time(0L);
        currTime.setTime(new Date().getTime());
        //crtIN = String.valueOf(currTime); //current time as some to init crtIN  TODO: convert to String
        CRTIN = "23:59:59";
        CRTEXPR = "00:00:00";
        INPUTIN = "00:00:00";
        row1.put("IDEX", IDEX);
        row1.put("NAME", NAME);
        row1.put("DESCRIPTION", DESCRIPTION);
        row1.put("CRTIN", CRTIN);
        row1.put("CRTEXPR", CRTEXPR);
        row1.put("INPUTIN", INPUTIN);
        itemsVI.insert("itemsVI", null, row1);

        for (int i = 1; i < 10; i++) { //FOR TESTING ONLY!
            ContentValues rowfor = new ContentValues();
            rowfor.put("IDEX", i);
            rowfor.put("NAME", "item" + i);
            rowfor.put("DESCRIPTION", DESCRIPTION);
            rowfor.put("CRTIN", CRTIN);
            rowfor.put("CRTEXPR", "00:00:00");
            rowfor.put("INPUTIN", "00:00:00");
            itemsVI.insert("itemsVI", null, rowfor);
        }
    }

    public void getDB(){
        if(checkDataBase()) {
            if (!checkDataBaseTable()) {
                initItemsVI();
            }
        }

    }


    public void clearSQL() {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase itemsVI = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        itemsVI.delete(TABLE_NAME, "name=?", new String[]{"itemsIV"});
        itemsVI.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase itemsVI, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        itemsVI.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(itemsVI);
    }
}
