package com.d0klabs.vashinternet_client.ui.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.databinding.FragmentHomeBinding;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.d0klabs.vashinternet_client.databinding.ContentCalendarBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragment<FragmentCalendarBining> extends Fragment implements LifecycleFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CalendarViewModel calendarViewModel;
    public ContentCalendarBinding fragmentCalendarBinding;

    public static MotionLayout calendarMotion;

    public CalendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       calendarViewModel = new ViewModelProvider(this).get(CalendarViewModel.class);
        fragmentCalendarBinding = ContentCalendarBinding.inflate(inflater, container, false);
        View root = fragmentCalendarBinding.getRoot();
        calendarViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), "Ця херня без кнопки", Toast.LENGTH_SHORT).show();
            }
        });

        /*mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button1 activity
                Toast.makeText(getContext(), "Відкривається вікно понеділка", Toast.LENGTH_SHORT).show();

            }
        });
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button2 activity
                Toast.makeText(getContext(), "Відкривається вікно вівторка", Toast.LENGTH_SHORT).show();
            }
        });
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button3 activity
                Toast.makeText(getContext(), "Відкривається вікно середи", Toast.LENGTH_SHORT).show();
            }
        });
        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button4 activity
                Toast.makeText(getContext(), "Відкривається вікно четверга", Toast.LENGTH_SHORT).show();
            }
        });
        mbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button5 activity
                Toast.makeText(getContext(), "Відкривається вікно дня випивки)", Toast.LENGTH_SHORT).show();
            }
        });

         */
        return inflater.inflate(R.layout.content_calendar, container, false);
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