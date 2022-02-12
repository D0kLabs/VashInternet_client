package com.d0klabs.vashinternet_client.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> currentTask;

    public HomeViewModel() {
        currentTask = new MutableLiveData<>();
        currentTask.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return currentTask;
    }
}