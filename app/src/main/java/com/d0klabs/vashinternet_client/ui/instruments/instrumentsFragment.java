package com.d0klabs.vashinternet_client.ui.instruments;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.database.dbInstrumentsHandler;
import com.d0klabs.vashinternet_client.databinding.InstrumentsFragmentBinding;
import com.d0klabs.vashinternet_client.ui.sklad.ItemTouchHelperCallback;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import static com.d0klabs.vashinternet_client.database.dbInstrumentsHandler.TableNames;

public class instrumentsFragment extends Fragment implements LifecycleFragment{
    public static TabLayout tabs;
    private InstrumentsViewModel mViewModel;
    private InstrumentsFragmentBinding instrumentsFragmentBinding;
    public static String[][] recyclerInstrumentsList;
    public static int[][] recyclerPriceList;
    public static Integer[][] recyclerRepCostList;
    public static int sz = 0;




    public static instrumentsFragment newInstance() {
        return new instrumentsFragment();
    }

    public static void setSize(int count) {
        sz = TableNames.length * count;
    }
    public static int getSize() {
        for (int u = 0; u < TableNames.length; u++) {
            try (Cursor instrumentsCount = MainActivity.dbInstrumentsHandler.getWritableDatabase().query(TableNames[u], new String[]{dbInstrumentsHandler.COL_INSTNAME}, null, null, null, null, null)) {
                int count = instrumentsCount.getCount();
                instrumentsFragment.setSize(count);
                if (instrumentsCount != null) instrumentsCount.close();
                sz = TableNames.length * count;
            }
        }
        return sz;
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
        cardRecyclerView.setLayoutManager( new LinearLayoutManager(this.getContext()));
        InstrumentsAdapter instrumentsAdapter = new InstrumentsAdapter(this.getContext());
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


}