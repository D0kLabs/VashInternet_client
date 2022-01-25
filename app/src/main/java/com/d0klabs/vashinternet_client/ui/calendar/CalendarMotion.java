package com.d0klabs.vashinternet_client.ui.calendar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class CalendarMotion extends Fragment {
    private CalendarViewModel calendarViewModel;
    public void onStart() {
        super.onStart();
        calendarViewModel = new ViewModelProvider(requireActivity()).get(CalendarViewModel.class);
    }
}