package com.d0klabs.vashinternet_client.ui.sklad;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;

public class SkladFragment extends Fragment {

    private String[] item;
    private String text, name;
    private View view;
    private RecyclerView skladRecView;
    private RecyclerView.LayoutManager layoutManager;

    public SkladFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sklad, container, false);
        skladRecView = view.findViewById(R.id.skladRecyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        skladRecView.setLayoutManager(layoutManager);


        SearchView searchView = view.findViewById(R.id.skladSearch);
        return view ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.ViewHolder skladCreatedRec = skladRecView.getChildViewHolder(view);

    }
}

