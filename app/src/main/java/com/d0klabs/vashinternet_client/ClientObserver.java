package com.d0klabs.vashinternet_client;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.d0klabs.vashinternet_client.ui.calendar.CalendarViewModel;

public class ClientObserver implements LifecycleObserver {
    private Owner owner;
    public ClientObserver(Lifecycle lifecycle, Owner usr){
        this.owner=usr;
        lifecycle.addObserver(this);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
            final CalendarViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this).get(CalendarViewModel.class);
            viewModel.getUser().observe((LifecycleOwner) this, new Observer() {
                @Override
                public void onChanged(Object o) {

                }
            });
    }
    enum Owner {
        FRAGMENT, SERVICE
    }
}
