package com.d0klabs.vashinternet_client;

import static com.d0klabs.vashinternet_client.R.id.motion_button1;
import static com.d0klabs.vashinternet_client.R.id.motion_button2;
import static com.d0klabs.vashinternet_client.R.id.motion_button3;
import static com.d0klabs.vashinternet_client.R.id.motion_button4;
import static com.d0klabs.vashinternet_client.R.id.motion_button5;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
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
    ClientObserver clientObserver = new ClientObserver(getLifecycle(), ClientObserver.Owner.SERVICE);
    private Button mot_button1 = findViewById(motion_button1);
    private Button mot_button2 = findViewById(motion_button2);
    private Button mot_button3 = findViewById(motion_button3);
    private Button mot_button4 = findViewById(motion_button4);
    private Button mot_button5 = findViewById(motion_button5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
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
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_calendar, R.id.nav_instruments, R.id.nav_sklad, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        findViewById(motion_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button1 activity
            }
        });
        findViewById(motion_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button2 activity
            }
        });
        findViewById(motion_button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button3 activity
            }
        });
        findViewById(motion_button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button4 activity
            }
        });
        findViewById(motion_button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start button5 activity
            }
        });

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

    protected void onStop(){
        super.onStop();
    }

}