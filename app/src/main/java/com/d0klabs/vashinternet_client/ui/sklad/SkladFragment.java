package com.d0klabs.vashinternet_client.ui.sklad;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.d0klabs.vashinternet_client.databinding.SkladFragmentBinding;
import com.d0klabs.vashinternet_client.ui.ItemsBox;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public class SkladFragment extends Fragment implements LifecycleFragment {

    private SkladViewModel mViewModel;
    private String[] item;
    private String text, name;
    private View view;
    public RecyclerView.Adapter skladContext;
    private LinearLayoutManager layoutManager;
    private SkladFragmentBinding skladFragmentBinding;

    public static SkladFragment newInstance() {
        return new SkladFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(SkladViewModel.class);
        skladFragmentBinding = SkladFragmentBinding.inflate(inflater, container,false);
        View root = skladFragmentBinding.getRoot();
        skladContext = new SkladRecycler(ItemsBox.recyclerList,skladFragmentBinding.skladRecyclerView.getContext());

        layoutManager = new LinearLayoutManager(getActivity());
        skladFragmentBinding.skladRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                skladFragmentBinding.skladRecyclerView.getContext(), layoutManager.getOrientation()
        );
        skladFragmentBinding.skladRecyclerView.addItemDecoration(dividerItemDecoration);
        skladFragmentBinding.skladRecyclerView.setAdapter(skladContext);
        //TODO: Need ViewHolder connection!

        //return inflater.inflate(R.layout.sklad_fragment, container, false);
        return root;
    }


    @Override
    public <T extends LifecycleCallback> T getCallbackOrNull(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public void addCallback(String s, @NonNull LifecycleCallback lifecycleCallback) {

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