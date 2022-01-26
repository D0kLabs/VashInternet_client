package com.d0klabs.vashinternet_client.ui.calendar;

import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.d0klabs.vashinternet_client.ClientObserver;

public class CalendarViewModel extends ViewModel {
    public static MutableLiveData<String> calendarBox;
    public CalendarViewModel() { //Clear CalendarMotion Fragment
        calendarBox = new MutableLiveData<>();
        calendarBox.setValue("CalendarViewModel!");
    }

    public static Object getState(){

        return calendarBox.getValue();
    }
    public LiveData<String> getText()
    {
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