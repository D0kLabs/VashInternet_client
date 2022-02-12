package com.d0klabs.vashinternet_client.event;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.ui.calendar.Tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventRepo {
    public static String[][] currentDay;
    public static String[] currentTask;

    public static void initCurrentDay() {
        int c =0;
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < Tasks.taskCalendar.length; i++) {
            if(Tasks.taskCalendar[i][1].contains((MainActivity.dateText.subSequence(0,MainActivity.dateText.lastIndexOf(MainActivity.dateText))))){
                l.add(String.valueOf(Tasks.taskCalendar[i][1]));
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
        for (int i = 0; i < l.size(); i++) {
            int m=0;
            while (Tasks.taskCalendar[m][1].contains(l.get(i))){
                currentDay[i] = Tasks.taskCalendar[m];
            }
        }

    }

}
