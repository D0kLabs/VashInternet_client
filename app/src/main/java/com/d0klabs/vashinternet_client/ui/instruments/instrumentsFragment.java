package com.d0klabs.vashinternet_client.ui.instruments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.databinding.InstrumentsFragmentBinding;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

public class instrumentsFragment extends Fragment implements LifecycleFragment{

    private InstrumentsViewModel mViewModel;
    private InstrumentsFragmentBinding instrumentsFragmentBinding;

    public static instrumentsFragment newInstance() {
        return new instrumentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.instruments_fragment, container, false);
        TabLayout tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        TabItem tabItem1 = (TabItem) rootView.findViewById(R.id.cardTab1);
        TabItem tabItem2 = (TabItem) rootView.findViewById(R.id.cardTab2);
        TabItem tabItem3 = (TabItem) rootView.findViewById(R.id.cardTab3);
        TabItem tabItem4 = (TabItem) rootView.findViewById(R.id.cardTab4);
        CardView cardView = (CardView) rootView.findViewById(R.id.instrumentsCardView);

        return inflater.inflate(R.layout.instruments_fragment, container, false);
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