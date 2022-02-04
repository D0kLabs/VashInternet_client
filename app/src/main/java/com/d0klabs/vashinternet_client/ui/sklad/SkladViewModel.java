package com.d0klabs.vashinternet_client.ui.sklad;

import android.widget.Button;

import androidx.lifecycle.ViewModel;


public class SkladViewModel extends ViewModel {
    public static void initButtonList() {
        CustomAdapter.buttons = new Button[60];
        for (int i = 0; i < CustomAdapter.buttons.length; i++) {
          //  CustomAdapter.buttons[i] = new Button();
          //  CustomAdapter.buttons[i].setText(Items.recyclerItemList[i]);
            CustomAdapter.buttons[i] = (CustomAdapter.ViewHolder.recycleButton);

        }
    }

    public static void createAndAddNewButton(){
        for (int i = 0; i < Items.recyclerItemList.length; i++) {
            CustomAdapter.buttons[i].setText(Items.recyclerItemList[i]);

        }
            //CustomAdapter.buttons[1] = (CustomAdapter.ViewHolder.recycleButton);
    }
}