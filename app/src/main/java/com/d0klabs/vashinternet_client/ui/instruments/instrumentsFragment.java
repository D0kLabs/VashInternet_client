package com.d0klabs.vashinternet_client.ui.instruments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.databinding.InstrumentsFragmentBinding;
import com.d0klabs.vashinternet_client.ui.sklad.ItemTouchHelperCallback;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class instrumentsFragment extends Fragment implements LifecycleFragment{
    public static TabLayout tabs;
    private InstrumentsViewModel mViewModel;
    private InstrumentsFragmentBinding instrumentsFragmentBinding;
    public List<instruments> instruments = getListData();


    public static instrumentsFragment newInstance() {
        return new instrumentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.instruments_fragment, container, false);
        tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        TabItem tabItem1 = (TabItem) rootView.findViewById(R.id.cardTab1);
        TabItem tabItem2 = (TabItem) rootView.findViewById(R.id.cardTab2);
        TabItem tabItem3 = (TabItem) rootView.findViewById(R.id.cardTab3);
        TabItem tabItem4 = (TabItem) rootView.findViewById(R.id.cardTab4);
        RecyclerView cardRecyclerView = (RecyclerView) rootView.findViewById(R.id.instrumentsRecyclerView);
        RecyclerView.LayoutManager instrumLayoutManager = new RecyclerView.LayoutManager() {

            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return null;
            }


        };
        cardRecyclerView.setLayoutManager(instrumLayoutManager);
        InstrumentsAdapter instrumentsAdapter = new InstrumentsAdapter(this.getContext(),instruments);
        cardRecyclerView.setAdapter(instrumentsAdapter);
        ItemTouchHelper.Callback instrumentsCallback = new ItemTouchHelperCallback(instrumentsAdapter);
        ItemTouchHelper instrumentsTouchHelper = new ItemTouchHelper(instrumentsCallback);
        instrumentsTouchHelper.attachToRecyclerView(cardRecyclerView);
        //cardRecyclerView.setBackgroundResource(R.drawable.building_g871b9c998_640); //get custom b_ground
        return rootView;
        //return inflater.inflate(R.layout.instruments_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InstrumentsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public <T extends LifecycleCallback> T getCallbackOrNull(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public void addCallback(String s, @NonNull @NotNull LifecycleCallback lifecycleCallback) {

    }

    @Override
    public Activity getLifecycleActivity() {
        return null;
    }

    @Override
    public boolean isCreated() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    private  List<instruments> getListData() {
        List<instruments> list = new ArrayList<instruments>();
        Country vietnam = new Country("Vietnam", "vn", 98000000);
        Country usa = new Country("United States", "us", 320000000);
        Country russia = new Country("Russia", "ru", 142000000);
        Country autraylia = new Country("Autraylia", "au", 25000000);
        Country japan = new Country("Japan", "jp", 126000000);

        list.add(vietnam);
        list.add(usa);
        list.add(russia);
        list.add(autraylia);
        list.add(japan);

        return list;
    }

}