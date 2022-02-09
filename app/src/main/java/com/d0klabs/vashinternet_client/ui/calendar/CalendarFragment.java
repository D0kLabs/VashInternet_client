package com.d0klabs.vashinternet_client.ui.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.databinding.ContentCalendarBinding;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragment<FragmentCalendarBining> extends Fragment implements LifecycleFragment {

    // Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Rename and change types of parameters
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
    // Rename and change types and number of parameters
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
        MaterialCardView btnLostWeek = (MaterialCardView) root.findViewById(R.id.undoneForLastWeek);
        TextView lostWeekBrief = (TextView) root.findViewById(R.id.undoneLastWeekBrief);
        MaterialCardView btn1 = (MaterialCardView) root.findViewById(R.id.motion_button1);
        TextView btn1DoW = (TextView) root.findViewById(R.id.button1dayofweek);
        TextView btn1Date = (TextView) root.findViewById(R.id.button1date);
        ProgressBar btn1ProgBar = root.findViewById(R.id.button1ProgresBar);
        TextView btn1Brief = (TextView) root.findViewById(R.id.button1brief);
        MaterialCardView btn2 = (MaterialCardView) root.findViewById(R.id.motion_button2);
        TextView btn2DoW = (TextView) root.findViewById(R.id.button2dayofweek);
        TextView btn2Date = (TextView) root.findViewById(R.id.button2date);
        ProgressBar btn2ProgBar = root.findViewById(R.id.button2ProgresBar);
        TextView btn2Brief = (TextView) root.findViewById(R.id.button2brief);
        MaterialCardView btn3 = (MaterialCardView) root.findViewById(R.id.motion_button3);
        TextView btn3DoW = (TextView) root.findViewById(R.id.button3dayofweek);
        TextView btn3Date = (TextView) root.findViewById(R.id.button3date);
        ProgressBar btn3ProgBar = root.findViewById(R.id.button3ProgresBar);
        TextView btn3Brief = (TextView) root.findViewById(R.id.button3brief);
        MaterialCardView btn4 = (MaterialCardView) root.findViewById(R.id.motion_button4);
        TextView btn4DoW = (TextView) root.findViewById(R.id.button4dayofweek);
        TextView btn4Date = (TextView) root.findViewById(R.id.button4date);
        ProgressBar btn4ProgBar = root.findViewById(R.id.button4ProgresBar);
        TextView btn4Brief = (TextView) root.findViewById(R.id.button4brief);
        MaterialCardView btn5 = (MaterialCardView) root.findViewById(R.id.motion_button5);
        TextView btn5DoW = (TextView) root.findViewById(R.id.button5dayofweek);
        TextView btn5Date = (TextView) root.findViewById(R.id.button5date);
        ProgressBar btn5ProgBar = root.findViewById(R.id.button5ProgresBar);
        TextView btn5Brief = (TextView) root.findViewById(R.id.button5brief);
        //return inflater.inflate(R.layout.content_calendar, container, false);
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