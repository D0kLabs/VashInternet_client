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
    private LocationManager mManager;
    private Context mContext;

    public static void getTaskList(){
        Cursor taskList = MainActivity.dbCalendarHandler.getWritableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME, null);
        int c = taskList.getCount();
        taskList.moveToFirst();
        taskCalendar = new String[c][11];
        pricesTaskCalendar = new int[c][2];
        for (int i = 1; i < c; i++) {
           taskCalendar[i][1] = taskList.getString(taskList.getColumnIndex("ID"));
            taskCalendar[i][2] = taskList.getString(taskList.getColumnIndex("DATA"));
            taskCalendar[i][3] = taskList.getString(taskList.getColumnIndex("DAYOFWEEK"));
            taskCalendar[i][4] = taskList.getString(taskList.getColumnIndex("DESCRIPTION"));
            taskCalendar[i][5] = taskList.getString(taskList.getColumnIndex("TASK"));
            taskCalendar[i][6] = taskList.getString(taskList.getColumnIndex("PLANTIMESTART"));
            taskCalendar[i][7] = taskList.getString(taskList.getColumnIndex("PLANTIMEEND"));
            taskCalendar[i][8] = taskList.getString(taskList.getColumnIndex("TIMESTART"));
            taskCalendar[i][9] = taskList.getString(taskList.getColumnIndex("TIMEEND"));
            taskCalendar[i][10] = taskList.getString(taskList.getColumnIndex("TOOLS"));
            taskCalendar[i][11] = taskList.getString(taskList.getColumnIndex("TASKUPDTIME"));
            pricesTaskCalendar[i][1] = taskList.getInt(taskList.getColumnIndex("DAYPRICE"));
            pricesTaskCalendar[i][2] = taskList.getInt(taskList.getColumnIndex("REPAIRCOST"));
            taskList.moveToNext(); // TODO: upgrade!!! maybe using positions
        }
        if(taskList != null) taskList.close();
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
}
