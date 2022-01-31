package com.d0klabs.vashinternet_client.ui.sklad;

import android.view.View;
import android.widget.Button;

import androidx.lifecycle.ViewModel;

import com.d0klabs.vashinternet_client.R;


public class SkladViewModel extends ViewModel {
    public static void initButtonList() {
        CustomAdapter.buttons = new Button[60];
        for (int i = 0; i < CustomAdapter.buttons.length; i++) {
            CustomAdapter.buttons[i] = (CustomAdapter.ViewHolder.recycleButton);
            //CustomAdapter.buttons[i].setText(Items.recyclerItemList[i]); // не працює бо ще не створено кнопки
        }
    }

    public static void createAndAddNewButton(){
            CustomAdapter.buttons[1] = (CustomAdapter.ViewHolder.recycleButton);
    }
}