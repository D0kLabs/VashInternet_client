package com.d0klabs.vashinternet_client.ui.sklad;

import android.view.View;
import android.widget.Button;

import androidx.lifecycle.ViewModel;

import com.d0klabs.vashinternet_client.R;


public class SkladViewModel extends ViewModel {


    public static void initButtonList() {
        CustomAdapter.buttons = new Button[60];
        CustomAdapter.buttons[0] = (CustomAdapter.ViewHolder.recycleButton);
    }

    public static void createAndAddNewButton(){
            CustomAdapter.buttons[1] = (CustomAdapter.ViewHolder.recycleButton);
    }
}