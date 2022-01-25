package com.d0klabs.vashinternet_client.ui.calendar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalendarViewModel extends ViewModel {
    private MutableLiveData<Boolean> showCalendarBox = new MutableLiveData<>();

    //new thread
    public void doSomeThing(){
        showCalendarBox.postValue(true);
    //  ...
        showCalendarBox.postValue(false);
    }

    public MutableLiveData<Boolean> getProgressState(){

        return showCalendarBox;
    }
}
