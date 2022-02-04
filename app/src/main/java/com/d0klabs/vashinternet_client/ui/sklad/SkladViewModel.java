package com.d0klabs.vashinternet_client.ui.sklad;

import androidx.lifecycle.ViewModel;


public class SkladViewModel extends ViewModel {

    public static void createAndAddNewButton(){
        for (int i = 0; i < Items.recyclerItemList.length; i++) {
            CustomAdapter.buttons[i].setText(Items.recyclerItemList[i]);

        }
            //CustomAdapter.buttons[1] = (CustomAdapter.ViewHolder.recycleButton);
    }
}