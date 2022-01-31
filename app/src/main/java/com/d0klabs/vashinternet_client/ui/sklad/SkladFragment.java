package com.d0klabs.vashinternet_client.ui.sklad;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.MainActivity;
import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.databinding.SkladFragmentBinding;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;

import java.util.ArrayList;

public class SkladFragment extends Fragment implements LifecycleFragment {

    private SkladViewModel mViewModel;
    public static LinearLayoutManager layoutManager;
    public static SkladFragmentBinding skladFragmentBinding;
    public static RecyclerView recyclerView;
    public  static Button[] buttonList ;
    //From simple android ...
    public static CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;


    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;


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
        View rootView = inflater.inflate(R.layout.sklad_fragment, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.skladRecyclerView);
        //skladFragmentBinding = SkladFragmentBinding.inflate(inflater,container,false);
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
        initDataset();
        mAdapter = new CustomAdapter(buttonList);
        recyclerView.setAdapter(mAdapter);
        MainActivity.skladAddButton = rootView.findViewById(R.id.floatingRecycleAddButton);

        MainActivity.skladAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkladViewModel.createAndAddNewButton();
                Toast.makeText(getContext(), "Додано новий елемент списку", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
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

    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        Items.initList();
        buttonList = new Button[DATASET_COUNT];
        SkladViewModel.initButtonList();
        Toast.makeText(getContext(), "Ініціалізовано кнопки", Toast.LENGTH_SHORT).show();
    }

}