package com.d0klabs.vashinternet_client.ui.calendar;

import android.content.Context;
import android.database.Cursor;
import android.location.LocationManager;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.database.dbCalendarHandler;

import static com.d0klabs.vashinternet_client.database.dbCalendarHandler.TABLE_NAME;


public class Tasks {
    public static String[] initCalendarID;
    public static String[][] taskCalendar;
    public static int[][] pricesTaskCalendar;
    public static String sPonedilokDate;
    public static String sVivtotkDate;
    public static String sSeredaDate;
    public static String sChetverDate;
    public static String sPuatnycaDate;
    public static String sPonedilkBrief;
    public static String sVivtotrokBrief;
    public static String sSeredaBrief;
    public static String sChetverBrief;
    public static String sPuatnycaBrief;
    private LocationManager mManager;
    private Context mContext;

    public static String[][] getTaskList(){
        Cursor taskList = MainActivity.dbCalendarHandler.getWritableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME, null);
        int c = taskList.getCount();
        taskList.moveToFirst();
        taskCalendar = new String[c][11];
        pricesTaskCalendar = new int[c][2];
        for (int i = 1; i < c; i++) {
           taskCalendar[i][0] = taskList.getString(taskList.getColumnIndex("ID"));
            taskCalendar[i][1] = taskList.getString(taskList.getColumnIndex("DATE"));
            taskCalendar[i][2] = taskList.getString(taskList.getColumnIndex("DAYOFWEEK"));
            taskCalendar[i][3] = taskList.getString(taskList.getColumnIndex("DESCRIPTION"));
            taskCalendar[i][4] = taskList.getString(taskList.getColumnIndex("TASK"));
            taskCalendar[i][5] = taskList.getString(taskList.getColumnIndex("PLANTIMESTART"));
            taskCalendar[i][6] = taskList.getString(taskList.getColumnIndex("PLANTIMEEND"));
            taskCalendar[i][7] = taskList.getString(taskList.getColumnIndex("TIMESTART"));
            taskCalendar[i][8] = taskList.getString(taskList.getColumnIndex("TIMEEND"));
            taskCalendar[i][9] = taskList.getString(taskList.getColumnIndex("TOOLS"));
            taskCalendar[i][10] = taskList.getString(taskList.getColumnIndex("TASKUPDTIME"));
            pricesTaskCalendar[i][0] = taskList.getInt(taskList.getColumnIndex("DAYPRICE"));
            pricesTaskCalendar[i][1] = taskList.getInt(taskList.getColumnIndex("REPAIRCOST"));
            taskList.moveToNext(); // TODO: upgrade!!! maybe using positions
        }
        if(taskList != null) taskList.close();
        return taskCalendar;
    }

    public static void initTasks(){
        Cursor initList = MainActivity.dbCalendarHandler.getWritableDatabase().query(dbCalendarHandler.TABLE_NAME, new String[]{dbCalendarHandler.COL_ID},null,null,null,null,null);
        int count = initList.getCount();
        initCalendarID = new String[count];
        initList.moveToFirst();
        for (int i = 1; i < count; i++) {
            initCalendarID[i] = initList.getString(initList.getColumnIndex("ID"));
            initList.moveToNext();
        }
        if(initList != null) initList.close();
    }
    public static void updateCalendarView(){

    }
    /*
    @RequiresApi(api = Build.VERSION_CODES.Q)

    public void testGnssProvidedClock(Context mContext) throws Exception {
        mManager = mContext.getSystemService(LocationManager.class);
        mManager.addTestProvider(GPS_PROVIDER,
                true,
                true,
                true,
                false,
                true,
                true,
                true,
                Criteria.POWER_LOW,
                Criteria.ACCURACY_COARSE);
        mManager.setTestProviderEnabled(GPS_PROVIDER, true);
        Location location = new Location(GPS_PROVIDER);
        long elapsed = SystemClock.elapsedRealtimeNanos();
        location.setLatitude(0);
        location.setLongitude(0);
        location.setAccuracy(0);
        location.setElapsedRealtimeNanos(elapsed);
        location.setTime(1);
        mManager.setTestProviderLocation(NETWORK_PROVIDER, location);
        assertTrue(SystemClock.currentGnssTimeClock().millis() < 1000);
        location.setTime(java.lang.System.currentTimeMillis());
        location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
        mManager.setTestProviderLocation(PASSIVE_PROVIDER, location);
        Thread.sleep(200);
        long clockms = SystemClock.currentGnssTimeClock().millis();
        assertTrue(System.currentTimeMillis() - clockms < 1000);
    }

     */
    public static void setTaskToCalendar(){
            StringBuilder briefPnBuilder = new StringBuilder();
            StringBuilder briefVtBuilder = new StringBuilder();
            StringBuilder briefSrBuilder = new StringBuilder();
            StringBuilder briefChBuilder = new StringBuilder();
            StringBuilder briefPtBuilder = new StringBuilder();
            for (int i = 1; i < taskCalendar.length; i++) {
                if (taskCalendar[i][2].contains("Понеділок")) {
                    sPonedilokDate = taskCalendar[i][1];
                    briefPnBuilder.append(String.valueOf(taskCalendar[i][4]) + "\n");
                }
                if (taskCalendar[i][2].contains("Вівторок")) {
                    sVivtotkDate = taskCalendar[i][1];
                    briefVtBuilder.append(String.valueOf(taskCalendar[i][4]) + "\n");
                }
                if (taskCalendar[i][2].contains("Середа")) {
                    sSeredaDate = taskCalendar[i][1];
                    briefSrBuilder.append(String.valueOf(taskCalendar[i][4])+ "\n");
                }
                if (taskCalendar[i][2].contains("Четвер")) {
                    sChetverDate = taskCalendar[i][1];
                    briefChBuilder.append(String.valueOf(taskCalendar[i][4]) + "\n");
                }
                if (taskCalendar[i][2].contains("П'ятниця")) {
                    sPuatnycaDate = taskCalendar[i][1];
                    briefPtBuilder.append(String.valueOf(taskCalendar[i][4]) + "\n");
                }
            }
            sPonedilkBrief = briefPnBuilder.toString();
            sVivtotrokBrief = briefVtBuilder.toString();
            sSeredaBrief = briefSrBuilder.toString();
            sChetverBrief = briefChBuilder.toString();
            sPuatnycaBrief = briefPtBuilder.toString();
    }
}
