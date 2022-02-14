package com.d0klabs.vashinternet_client.event;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.ui.calendar.Tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class EventRepo {
    public static String[][] currentDay;
    public static Date[][] currentDayTimes;
    public static String[] currentTask;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm:aa");
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm aa");

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void initCurrentDay() {
        int c =0;
        List<String> l = new ArrayList<String>();
        for (int i = 1; i < Tasks.taskCalendar.length; i++) {
            if(Tasks.taskCalendar[i][1].contains(String.valueOf(MainActivity.dateText))){
                if (!l.contains(String.valueOf(Tasks.taskCalendar[i][5]))) {
                    l.add(String.valueOf(Tasks.taskCalendar[i][5]));
                }
            }
            }
        Collections.sort(l, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                try {
                    return new SimpleDateFormat("hh:mm").parse(o1).compareTo(new SimpleDateFormat("hh:mm").parse(o2));
                } catch (ParseException e) {
                    return 0;
                }
            }
        });
        currentDay = new String [l.size()][11];
        currentDayTimes = new Date[l.size()][9];
        for (int i = 1; i < l.size(); i++) {
            for (int m = 1; m < Tasks.taskCalendar.length; m++) {
                if (Tasks.taskCalendar[m][5].contains(l.get(i))) {
                    currentDay[i] = Tasks.taskCalendar[m];
                    try {
                        currentDayTimes[i][1] = dateFormat.parse(currentDay[i][5]);
                        //currentDayTimes[i][2] = (dateFormat.parse(currentDay[i][6])) - (dateFormat.parse(currentDay[i][5]));
                        currentDayTimes[i][3] = dateFormat.parse(currentDay[i][6]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        // Write true time of Plan start, plan end time and it`s duration

    }

}
