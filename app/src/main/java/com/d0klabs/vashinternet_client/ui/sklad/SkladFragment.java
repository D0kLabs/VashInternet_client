package com.d0klabs.vashinternet_client.ui.sklad;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.databinding.SkladFragmentBinding;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;

import java.util.ArrayList;

public class SkladFragment extends Fragment implements LifecycleFragment {

    private SkladViewModel mViewModel;
    public static RecyclerView.Adapter skladAdapter;
    public static LinearLayoutManager layoutManager;
    public static SkladFragmentBinding skladFragmentBinding;
    public static RecyclerView.LayoutManager skladRecycleLayoutManager;
    public static RecyclerView.ViewHolder viewHolder;
    ArrayList<Button> recyclerItemList;
    public static RecyclerView recyclerView;
    //From simple android ...
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;
    protected String[] mDataset;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RadioButton mLinearLayoutRadioButton;
    protected RadioButton mGridLayoutRadioButton;


    public static SkladFragment newInstance() {
        return new SkladFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(SkladViewModel.class);
        View rootView = inflater.inflate(R.layout.sklad_fragment, container, false);
        rootView.setTag(TAG);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.skladRecyclerView);
        //skladFragmentBinding = SkladFragmentBinding.inflate(inflater,container,false);
        //skladAdapter = new Adapter(Items.recyclerItemList);
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        //SkladFragment.recyclerView.setAdapter(skladAdapter);

        //SkladFragment.layoutManager = new LinearLayoutManager(requireContext());
        //SkladFragment.recyclerView.setLayoutManager(layoutManager);
        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new CustomAdapter(recyclerItemList);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)



        return rootView;
        //return inflater.inflate(R.layout.sklad_fragment, container, false);
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

    /*public static class itemHolder extends RecyclerView.ViewHolder {
        public itemHolder(View fragmentView) {
            super(fragmentView);
            Items.initList(fragmentView.getContext());
        }
    }

     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
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
        Items.initList(getContext());
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {

            mDataset[i] = "This is element #" + i;
        }
    }
}