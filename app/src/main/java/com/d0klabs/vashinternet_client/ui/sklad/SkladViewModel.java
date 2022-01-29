package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import static com.d0klabs.vashinternet_client.ui.sklad.SkladFragment.skladFragmentBinding;


public class SkladViewModel extends ViewModel {

    public void init(Context context){
        SkladFragment.skladAdapter = new SkladRecycler(Items.recyclerItemList, context);
        SkladFragment.layoutManager = new LinearLayoutManager(context);
        skladFragmentBinding.skladRecyclerView.setLayoutManager(SkladFragment.layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                skladFragmentBinding.skladRecyclerView.getContext(), SkladFragment.layoutManager.getOrientation()
        );
        skladFragmentBinding.skladRecyclerView.addItemDecoration(dividerItemDecoration);
        skladFragmentBinding.skladRecyclerView.setAdapter(SkladFragment.skladAdapter);
    }
    public void setData(Context context){
        skladFragmentBinding.skladRecyclerView.setEnabled(true);

    }

}