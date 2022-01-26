package com.d0klabs.vashinternet_client;

import android.content.Intent;
import android.content.res.Configuration;
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
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

//TODO: Зміни в strings.xml !!!

//TODO: ЗМІНИ В nav_header_main.xml :
//TODO: Змінити android:background="@drawable/side_nav_bar" на мотоцикл
//TODO: Змінити app:srcCompat="@mipmap/ic_launcher_round" на фотку користувача

//TODO: Змінити в fragment_home.xml на перелік тасків на тиждень
//TODO: Змінити activity_main_drawer.xml меню до переліку пунктів
//TODO: по натисканню на меню Календар має відкритися фрейм з календарем для вибору дат. В фреймі має бути кнопка потчної дати.
//TODO: в content_calendar.xml відобразити набір даних на кнопках. Підписувати який це день тижня і дата. Час вказувати по тасках.

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Button motion_button1;
    private Button motion_button2;
    private Button motion_button3;
    private Button motion_button4;
    private Button motion_button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        Intent intent = getIntent();
        if( intent.getExtras() != null)
        {
            String language = intent.getExtras().getString("language"); /*String형*/

            if(language!=null){
                Locale eg = Locale.ENGLISH;
                Configuration config = new Configuration( );
                config.locale = eg;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );

            }
        }
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Написати ШЕФУ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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