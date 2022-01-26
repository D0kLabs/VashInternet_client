package com.d0klabs.vashinternet_client.ui.calendar;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.d0klabs.vashinternet_client.ClientObserver;

public class CalendarViewModel extends ViewModel {
    public static MutableLiveData<Object> calendarBox = new MutableLiveData<>();
    public CalendarViewModel(){ //Clear CalendarMotion Fragment


        calendarBox.setValue(ClientObserver.getData());
        calendarBox.notify();
    }

    public static Object getState(){

        return calendarBox.getValue();
    }
    
    void doAction() {
        // userLiveData.
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
        final ViewModel calendarViewModel = new CalendarViewModel();

        /*calendarViewModel.getData().observe((LifecycleOwner) this, new Observer() {
            @Override
            public void onChanged(Object o) {

            }
        });

         */
    }
    
}