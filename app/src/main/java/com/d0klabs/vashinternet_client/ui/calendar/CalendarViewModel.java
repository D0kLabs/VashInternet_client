package com.d0klabs.vashinternet_client.ui.calendar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalendarViewModel extends ViewModel {

    public static MutableLiveData<String> btn1Date;
    public static MutableLiveData<String> btn2Date;
    public static MutableLiveData<String> btn3Date;
    public static MutableLiveData<String> btn4Date;
    public static MutableLiveData<String> btn5Date;
    public static MutableLiveData<String> btn1Brief;
    public static MutableLiveData<String> btn2Brief;
    public static MutableLiveData<String> btn3Brief;
    public static MutableLiveData<String> btn4Brief;
    public static MutableLiveData<String> btn5Brief;

    public CalendarViewModel() { //Clear CalendarMotion Fragment
        Tasks.getTaskList();
        btn1Date = new MutableLiveData<>();
        btn2Date = new MutableLiveData<>();
        btn3Date = new MutableLiveData<>();
        btn4Date = new MutableLiveData<>();
        btn5Date = new MutableLiveData<>();
        btn1Brief = new MutableLiveData<>();
        btn2Brief = new MutableLiveData<>();
        btn3Brief = new MutableLiveData<>();
        btn4Brief = new MutableLiveData<>();
        btn5Brief = new MutableLiveData<>();
        btn1Date.setValue(Tasks.sPonedilokDate);
        btn2Date.setValue(Tasks.sVivtotkDate);
        btn3Date.setValue(Tasks.sSeredaDate);
        btn4Date.setValue(Tasks.sChetverDate);
        btn5Date.setValue(Tasks.sPuatnycaDate);
        btn1Brief.setValue(Tasks.sPonedilkBrief);
        btn2Brief.setValue(Tasks.sVivtotrokBrief);
        btn3Brief.setValue(Tasks.sSeredaBrief);
        btn4Brief.setValue(Tasks.sChetverBrief);
        btn5Brief.setValue(Tasks.sPuatnycaBrief);
    }


    public MutableLiveData<String> getBtn1Date() {
        if(btn1Date == null){
            btn1Date = new MutableLiveData<>();
        }
        return btn1Date;
    }
    public MutableLiveData<String> getBtn2Date() {
        if(btn2Date == null){
            btn2Date = new MutableLiveData<>();
        }
        return btn2Date;
    }
    public MutableLiveData<String> getBtn3Date() {
        if(btn3Date == null){
            btn3Date = new MutableLiveData<>();
        }
        return btn3Date;
    }
    public MutableLiveData<String> getBtn4Date() {
        if(btn4Date == null){
            btn4Date = new MutableLiveData<>();
        }
        return btn4Date;
    }
    public MutableLiveData<String> getBtn5Date() {
        if(btn5Date == null){
            btn5Date = new MutableLiveData<>();
        }
        return btn5Date;
    }
    public MutableLiveData<String> getBtn1Brief(){
        if(btn1Brief == null){
            btn1Brief = new MutableLiveData<>();
        }
        return  btn1Brief;
    }
    public MutableLiveData<String> getBtn2Brief(){
        if(btn2Brief == null){
            btn2Brief = new MutableLiveData<>();
        }
        return  btn2Brief;
    }
    public MutableLiveData<String> getBtn3Brief(){
        if(btn3Brief == null){
            btn3Brief = new MutableLiveData<>();
        }
        return  btn3Brief;
    }
    public MutableLiveData<String> getBtn4Brief(){
        if(btn4Brief == null){
            btn4Brief = new MutableLiveData<>();
        }
        return  btn4Brief;
    }
    public MutableLiveData<String> getBtn5Brief(){
        if(btn5Brief == null){
            btn5Brief = new MutableLiveData<>();
        }
        return  btn5Brief;
    }

    /*
    void doAction() {
        // userLiveData.
        btn1DayOfWeek.setValue(Tasks.taskCalendar); // or other
    }

     */

    /*@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
        final ViewModel calendarViewModel = new CalendarViewModel();

        calendarViewModel.getData().observe((LifecycleOwner) this, new Observer() {
            @Override
            public void onChanged(Object o) {

            }
        });


    }

     */
    
}