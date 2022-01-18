package com.d0klabs.vashinternet_client.ui.calendar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalendarViewModel extends ViewModel {
    private MutableLiveData<Boolean> showProgress = new MutableLiveData<>();

    //new thread
    public void doSomeThing(){
        showProgress.postValue(true);
    //  ...
        showProgress.postValue(false);
    }

    public MutableLiveData<Boolean> getProgressState(){
        return showProgress;
    }
}
