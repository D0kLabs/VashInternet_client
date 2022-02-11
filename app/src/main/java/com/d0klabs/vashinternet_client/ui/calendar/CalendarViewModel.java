package com.d0klabs.vashinternet_client.ui.calendar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalendarViewModel extends ViewModel {
    public static MutableLiveData<String> btn1DayOfWeek;
    public static MutableLiveData<String> btn2DayOfWeek;
    public static MutableLiveData<String> btn3DayOfWeek;
    public static MutableLiveData<String> btn4DayOfWeek;
    public static MutableLiveData<String> btn5DayOfWeek;
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
        btn1DayOfWeek = new MutableLiveData<>();
        btn1DayOfWeek.setValue(Tasks.taskCalendar[1][2]);
        btn2DayOfWeek = new MutableLiveData<>();
        btn2DayOfWeek.setValue(Tasks.taskCalendar[2][2]);
        btn3DayOfWeek = new MutableLiveData<>();
        btn3DayOfWeek.setValue(Tasks.taskCalendar[3][2]);
        btn4DayOfWeek = new MutableLiveData<>();
        btn4DayOfWeek.setValue(Tasks.taskCalendar[4][2]);
        btn5DayOfWeek = new MutableLiveData<>();
        btn5DayOfWeek.setValue(Tasks.taskCalendar[5][2]);
        btn1Date = new MutableLiveData<>();
        btn1Date.setValue(Tasks.taskCalendar[1][1]);
        btn2Date = new MutableLiveData<>();
        btn2Date.setValue(Tasks.taskCalendar[2][1]);
        btn3Date = new MutableLiveData<>();
        btn3Date.setValue(Tasks.taskCalendar[3][1]);
        btn4Date = new MutableLiveData<>();
        btn4Date.setValue(Tasks.taskCalendar[4][1]);
        btn5Date = new MutableLiveData<>();
        btn5Date.setValue(Tasks.taskCalendar[5][1]);
        btn1Brief = new MutableLiveData<>();
        btn1Brief.setValue(Tasks.taskCalendar[1][3]);
        btn2Brief = new MutableLiveData<>();
        btn2Brief.setValue(Tasks.taskCalendar[2][3]);
        btn3Brief = new MutableLiveData<>();
        btn3Brief.setValue(Tasks.taskCalendar[3][3]);
        btn4Brief = new MutableLiveData<>();
        btn4Brief.setValue(Tasks.taskCalendar[4][3]);
        btn5Brief = new MutableLiveData<>();
        btn5Brief.setValue(Tasks.taskCalendar[5][3]);
    }

    public static Object getState(){

        return btn1DayOfWeek.getValue();
    }
    public MutableLiveData<String> getBtn1DayOfWeek()
    {
        if (btn1DayOfWeek == null){
            btn1DayOfWeek = new MutableLiveData<>();
        }
        return btn1DayOfWeek;
    }
    public MutableLiveData<String> getBtn2DayOfWeek()
    {
        if (btn2DayOfWeek == null){
            btn2DayOfWeek = new MutableLiveData<>();
        }
        return btn2DayOfWeek;
    }
    public MutableLiveData<String> getBtn3DayOfWeek()
    {
        if (btn3DayOfWeek == null){
            btn3DayOfWeek = new MutableLiveData<>();
        }
        return btn3DayOfWeek;
    }
    public MutableLiveData<String> getBtn4DayOfWeek()
    {
        if (btn4DayOfWeek == null){
            btn4DayOfWeek = new MutableLiveData<>();
        }
        return btn4DayOfWeek;
    }
    public MutableLiveData<String> getBtn5DayOfWeek()
    {
        if (btn5DayOfWeek == null){
            btn5DayOfWeek = new MutableLiveData<>();
        }
        return btn5DayOfWeek;
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