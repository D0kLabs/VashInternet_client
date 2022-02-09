package com.d0klabs.vashinternet_client.ui.calendar;

import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.d0klabs.vashinternet_client.R;
import com.google.android.material.card.MaterialCardView;

import static com.d0klabs.vashinternet_client.ui.calendar.CalendarFragment.root;

public class CalendarViewModel extends ViewModel {
    public static MutableLiveData<String> calendarBox;
    MaterialCardView btnLostWeek = (MaterialCardView) root.findViewById(R.id.undoneForLastWeek);
    TextView lostWeekBrief = (TextView) root.findViewById(R.id.undoneLastWeekBrief);
    MaterialCardView btn1 = (MaterialCardView) root.findViewById(R.id.motion_button1);
    TextView btn1DoW = (TextView) root.findViewById(R.id.button1dayofweek);
    TextView btn1Date = (TextView) root.findViewById(R.id.button1date);
    ProgressBar btn1ProgBar = root.findViewById(R.id.button1ProgresBar);
    TextView btn1Brief = (TextView) root.findViewById(R.id.button1brief);
    MaterialCardView btn2 = (MaterialCardView) root.findViewById(R.id.motion_button2);
    TextView btn2DoW = (TextView) root.findViewById(R.id.button2dayofweek);
    TextView btn2Date = (TextView) root.findViewById(R.id.button2date);
    ProgressBar btn2ProgBar = root.findViewById(R.id.button2ProgresBar);
    TextView btn2Brief = (TextView) root.findViewById(R.id.button2brief);
    MaterialCardView btn3 = (MaterialCardView) root.findViewById(R.id.motion_button3);
    TextView btn3DoW = (TextView) root.findViewById(R.id.button3dayofweek);
    TextView btn3Date = (TextView) root.findViewById(R.id.button3date);
    ProgressBar btn3ProgBar = root.findViewById(R.id.button3ProgresBar);
    TextView btn3Brief = (TextView) root.findViewById(R.id.button3brief);
    MaterialCardView btn4 = (MaterialCardView) root.findViewById(R.id.motion_button4);
    TextView btn4DoW = (TextView) root.findViewById(R.id.button4dayofweek);
    TextView btn4Date = (TextView) root.findViewById(R.id.button4date);
    ProgressBar btn4ProgBar = root.findViewById(R.id.button4ProgresBar);
    TextView btn4Brief = (TextView) root.findViewById(R.id.button4brief);
    MaterialCardView btn5 = (MaterialCardView) root.findViewById(R.id.motion_button5);
    TextView btn5DoW = (TextView) root.findViewById(R.id.button5dayofweek);
    TextView btn5Date = (TextView) root.findViewById(R.id.button5date);
    ProgressBar btn5ProgBar = root.findViewById(R.id.button5ProgresBar);
    TextView btn5Brief = (TextView) root.findViewById(R.id.button5brief);
    public CalendarViewModel() { //Clear CalendarMotion Fragment
        calendarBox = new MutableLiveData<>();
        calendarBox.setValue("CalendarViewModel!");
    }

    public static Object getState(){

        return calendarBox.getValue();
    }
    public LiveData<String> getText()
    {
        if (calendarBox == null){
            calendarBox = new MutableLiveData<String>();
        }
        return calendarBox;
    }
    void doAction() {
        // userLiveData.
        calendarBox.setValue("CalendarViewModel!");
    }

    /*@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
        final ViewModel calendarViewModel = new CalendarViewModel();

        calendarViewModel.getData().observe((LifecycleOwner) this, new Observer() {
            @Override
            public void onChanged(Object o) {

            }
        });


    }

     */
    
}