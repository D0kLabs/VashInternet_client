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
    private static final String TABLE_NAME = "items";


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
    public static int IDEX; //index of itemList
    public static String NAME; //text for button
    public static String DESCRIPTION; // text for inside view
    public static String CRTIN; // time of input at @sklad
    public static String CRTEXPR; // time of expiration (00:00 if none) TODO: test time 00:00
    public static String INPUTIN; // time of adding to sql
    // END SQL USING

    @Override
    public void onCreate(SQLiteDatabase itemsVI) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + IDEX + " INTEGER PRIMARY KEY AUTOINCREMENT " + NAME + " TEXT" + DESCRIPTION + " TEXT" + CRTIN + " TEXT" + CRTEXPR + " TEXT" + INPUTIN + "TEXT)";

        itemsVI.execSQL(query);
    }

    public void initItemsVI(){
        SQLiteDatabase itemsVI = this.getWritableDatabase();
        ContentValues row1 = new ContentValues();
        IDEX = 0;
        NAME = "zerobutton";
        DESCRIPTION = "Therearenodescriptionfound.PleasecallCHIEF";
        Time currTime = new Time(0L);
        currTime.setTime(new Date().getTime());
        //crtIN = String.valueOf(currTime); //current time as some to init crtIN  TODO: convert to String
        CRTIN = "23:59:59";
        CRTEXPR = String.valueOf("00:00:00");
        INPUTIN = String.valueOf("00:00:00");
        row1.put("IDEX", IDEX);
        row1.put("NAME", NAME);
        row1.put("DESCRIPTION", DESCRIPTION);
        row1.put("CRTIN", CRTIN);
        row1.put("crtEXPR", CRTEXPR);
        row1.put("inputIN", INPUTIN);
        itemsVI.insert("items",null, row1);
    }


    @Override
    public void onUpgrade(SQLiteDatabase itemsVI, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        itemsVI.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(itemsVI);
    }
}
