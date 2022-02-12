package com.d0klabs.vashinternet_client.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    public static SeekBar homeSeekBar;
    public static ProgressBar homeProgBar;
    public static RatingBar homeRatingBar;
    public static TextView homeCurrentTaskTextVw;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeCurrentTaskTextVw = (TextView) root.findViewById(R.id.textView2);
        RecyclerView homeRecyclerView = (RecyclerView) root.findViewById(R.id.homeRecycler);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TasksAdapter homeTaskAdapter = new TasksAdapter(this.getContext());
        homeRecyclerView.setAdapter(homeTaskAdapter);
        //final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String ct) {
                homeCurrentTaskTextVw.setText(ct);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}