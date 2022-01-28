package com.d0klabs.vashinternet_client;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.d0klabs.vashinternet_client.databinding.ActivityMainBinding;
import com.d0klabs.vashinternet_client.ui.sklad.Items;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        mbutton1 = (Button) findViewById(R.id.motion_button1);
        mbutton2 = (Button) findViewById(R.id.motion_button2);
        mbutton3 = (Button) findViewById(R.id.motion_button3);
        mbutton4 = (Button) findViewById(R.id.motion_button4);
        mbutton5 = (Button) findViewById(R.id.motion_button5);
        Items.initList(); //MOVE TO onCREATE on Main
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

    }

    protected void onStop(){
        super.onStop();
    }

}