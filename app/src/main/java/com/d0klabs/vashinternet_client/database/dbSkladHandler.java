package com.d0klabs.vashinternet_client.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;
import java.util.Date;

public class dbSkladHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "itemsVashInternet";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "itemsVI";


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
    public static String IDEX = "id"; //index of itemList
    public static String NAME = "name"; //text for button
    public static String DESCRIPTION = "description"; // text for inside view
    public static String CRTIN = "crtin"; // time of input at @sklad
    public static String CRTEXPR = "crtexpr"; // time of expiration (00:00 if none) TODO: test time 00:00
    public static String INPUTIN = "inputin"; // time of adding to sql
    // END SQL USING

    @Override
    public void onCreate(SQLiteDatabase itemsVI) {

        itemsVI.execSQL("CREATE TABLE " + TABLE_NAME
                + " (" + IDEX + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT NOT NULL,"
                + DESCRIPTION + " TEXT NOT NULL,"
                + CRTIN + " TEXT NOT NULL,"
                + CRTEXPR + " TEXT NOT NULL,"
                + INPUTIN + " TEXT NOT NULL);");
    }

    public void initItemsVI(){
        SQLiteDatabase itemsVI = this.getWritableDatabase();
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
        itemsVI.insert("itemsVI",null, row1);
    }

    public void clearSQL() {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase itemsVI = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        itemsVI.delete(TABLE_NAME, "name=?", new String[]{"items"});
        itemsVI.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase itemsVI, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        itemsVI.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(itemsVI);
    }
}
