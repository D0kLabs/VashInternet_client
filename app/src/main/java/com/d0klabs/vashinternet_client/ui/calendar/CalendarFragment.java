package com.d0klabs.vashinternet_client.ui.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    public static View root;

    // Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CalendarViewModel calendarViewModel;
    public ContentCalendarBinding fragmentCalendarBinding;
    MaterialCardView btnLostWeek, btn1, btn2, btn3, btn4, btn5;
    TextView lostWeekBrief, btn1DoW, btn1Date, btn1Brief, btn2DoW, btn2Date, btn2Brief, btn3DoW, btn3Date, btn3Brief, btn4DoW, btn4Date, btn4Brief, btn5DoW, btn5Date, btn5Brief;
    ProgressBar btn1ProgBar, btn2ProgBar, btn3ProgBar, btn4ProgBar, btn5ProgBar;


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
        root = fragmentCalendarBinding.getRoot();
        btnLostWeek = (MaterialCardView) root.findViewById(R.id.undoneForLastWeek);
        lostWeekBrief = (TextView) root.findViewById(R.id.undoneLastWeekBrief);
        btn1 = (MaterialCardView) root.findViewById(R.id.motion_button1);
        btn1DoW = (TextView) root.findViewById(R.id.button1dayofweek);
        btn1Date = (TextView) root.findViewById(R.id.button1date);
        btn1ProgBar = root.findViewById(R.id.button1ProgresBar);
        btn1Brief = (TextView) root.findViewById(R.id.button1brief);
        btn2 = (MaterialCardView) root.findViewById(R.id.motion_button2);
        btn2DoW = (TextView) root.findViewById(R.id.button2dayofweek);
        btn2Date = (TextView) root.findViewById(R.id.button2date);
        btn2ProgBar = root.findViewById(R.id.button2ProgresBar);
        btn2Brief = (TextView) root.findViewById(R.id.button2brief);
        btn3 = (MaterialCardView) root.findViewById(R.id.motion_button3);
        btn3DoW = (TextView) root.findViewById(R.id.button3dayofweek);
        btn3Date = (TextView) root.findViewById(R.id.button3date);
        btn3ProgBar = root.findViewById(R.id.button3ProgresBar);
        btn3Brief = (TextView) root.findViewById(R.id.button3brief);
        btn4 = (MaterialCardView) root.findViewById(R.id.motion_button4);
        btn4DoW = (TextView) root.findViewById(R.id.button4dayofweek);
        btn4Date = (TextView) root.findViewById(R.id.button4date);
        btn4ProgBar = root.findViewById(R.id.button4ProgresBar);
        btn4Brief = (TextView) root.findViewById(R.id.button4brief);
        btn5 = (MaterialCardView) root.findViewById(R.id.motion_button5);
        btn5DoW = (TextView) root.findViewById(R.id.button5dayofweek);
        btn5Date = (TextView) root.findViewById(R.id.button5date);
        btn5ProgBar = root.findViewById(R.id.button5ProgresBar);
        btn5Brief = (TextView) root.findViewById(R.id.button5brief);
        calendarViewModel.getBtn1DayOfWeek().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s1) {
                btn1DoW.setText(s1);
            }

        });
        calendarViewModel.getBtn2DayOfWeek().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s2) {
                btn2DoW.setText(s2);
            }
        });
        calendarViewModel.getBtn3DayOfWeek().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s3) {
                btn3DoW.setText(s3);
            }
        });
        calendarViewModel.getBtn4DayOfWeek().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s4) {
                btn4DoW.setText(s4);
            }
        });
        calendarViewModel.getBtn5DayOfWeek().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s5) {
                btn5DoW.setText(s5);
            }
        });
        calendarViewModel.getBtn1Date().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String sd1) {
                btn1Date.setText(sd1);
            }
        });
        calendarViewModel.getBtn2Date().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String sd2) {
                btn2Date.setText(sd2);
            }
        });
        calendarViewModel.getBtn3Date().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String sd3) {
                btn3Date.setText(sd3);
            }
        });
        calendarViewModel.getBtn4Date().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String sd4) {
                btn4Date.setText(sd4);
            }
        });
        calendarViewModel.getBtn5Date().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String sd5) {
                btn5Date.setText(sd5);
            }
        });



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