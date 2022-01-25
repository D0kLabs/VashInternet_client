package com.d0klabs.vashinternet_client.ui.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.auth.User;

public class CalendarViewModel extends ViewModel {
    private final MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public LiveData<User> getUser() {
        return userLiveData;
    }
    public final MutableLiveData<Object> calendarBox;
    public CalendarViewModel(Object a){
        calendarBox = new MutableLiveData<>();
        calendarBox.setValue(a);
    }

    public Object getState(){
        return calendarBox.getValue();
    }
    
    void doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }
    
}