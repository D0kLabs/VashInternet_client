package com.d0klabs.vashinternet_client.ui.instruments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.databinding.InstrumentsFragmentBinding;

public class instrumentsFragment extends Fragment {

    private InstrumentsViewModel mViewModel;
    private InstrumentsFragmentBinding instrumentsFragmentBinding;

    public static instrumentsFragment newInstance() {
        return new instrumentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.instruments_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InstrumentsViewModel.class);
        // TODO: Use the ViewModel
    }

}