package com.d0klabs.vashinternet_client.ui.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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