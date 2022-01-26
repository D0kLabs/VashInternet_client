package com.d0klabs.vashinternet_client;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.google.firebase.firestore.auth.User;

public class ClientObserver implements LifecycleObserver {
    public Owner owner;
    public static final MutableLiveData<User> userLiveData = new MutableLiveData<>();


    public static LiveData<User> getData() {
        return userLiveData;
    }

    public ViewModelStoreOwner getOwner() {
        Owner cnt = this.owner;
        return cnt;
    }


    enum Owner implements ViewModelStoreOwner {
        FRAGMENT, SERVICE;

        @NonNull
        @Override
        public ViewModelStore getViewModelStore() {
            return null;
        }
    }
}
