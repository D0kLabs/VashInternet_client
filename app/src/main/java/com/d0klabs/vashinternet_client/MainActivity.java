package com.d0klabs.vashinternet_client;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.d0klabs.vashinternet_client.database.dbCalendarHandler;
import com.d0klabs.vashinternet_client.database.dbInstrumentsHandler;
import com.d0klabs.vashinternet_client.database.dbSkladHandler;
import com.d0klabs.vashinternet_client.databinding.ActivityMainBinding;
import com.d0klabs.vashinternet_client.event.EventRepo;
import com.d0klabs.vashinternet_client.ui.calendar.Tasks;
import com.d0klabs.vashinternet_client.ui.instruments.instruments;
import com.d0klabs.vashinternet_client.ui.sklad.Items;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


//TODO: по натисканню на меню Календар має відкритися фрейм з календарем для вибору дат. В фреймі має бути кнопка потчної дати.

public class MainActivity extends AppCompatActivity {

    public AppBarConfiguration mAppBarConfiguration;
    public ActivityMainBinding binding;
    public static Button mbutton1;
    public static Button mbutton2;
    public static Button mbutton3;
    public static Button mbutton4;
    public static Button mbutton5;
    public static FloatingActionButton skladAddButton;
    public static dbSkladHandler dbHandler;
    public static dbInstrumentsHandler dbInstrumentsHandler;
    public static dbCalendarHandler dbCalendarHandler;
    public static DateTimeFormatter dateFormat, timeFormat;
    public static String dateText, timeText;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // dateText = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now());
       // timeText = DateTimeFormatter.ISO_LOCAL_TIME.format(LocalTime.now());



        binding = ActivityMainBinding.inflate(getLayoutInflater());

        Intent intent = getIntent();

        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Написати ШЕФУ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        skladAddButton = (FloatingActionButton) findViewById(R.id.floatingRecycleAddButton);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.nav_home);
        topLevelDestinations.add(R.id.nav_calendar);
        topLevelDestinations.add(R.id.nav_instruments);
        topLevelDestinations.add(R.id.nav_sklad);
        mAppBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations).setDrawerLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        dbHandler = new dbSkladHandler(MainActivity.this);
        dbHandler.setWriteAheadLoggingEnabled(true);
        dbInstrumentsHandler = new dbInstrumentsHandler(MainActivity.this);
        dbInstrumentsHandler.setWriteAheadLoggingEnabled(true);
        dbCalendarHandler = new dbCalendarHandler(MainActivity.this);
        dbCalendarHandler.setWriteAheadLoggingEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //dbHandler.setTestData_toDB();
        //dbInstrumentsHandler.setTestData_toDB();
        //dbCalendarHandler.setTestData_toDB();
        Items.initList();
        instruments.updateInfoFromDB();
        //Tasks.initTasks();
        Tasks.getTaskList();
        Tasks.setTaskToCalendar();
        EventRepo.initCurrentDay();
    }

    protected void onStop(){
        super.onStop();
    }

}