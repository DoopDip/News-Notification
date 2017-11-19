package com.adv.newsnotification;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.pushbots.push.Pushbots;

public class MainActivity extends FragmentActivity {

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pushbots.sharedInstance().init(this);
        Pushbots.sharedInstance().registerForRemoteNotifications();

        //First Fragment
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frameLayout, new HomeFragment()).addToBackStack(null).commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Log.d("Click","Home");
                        HomeFragment homeFragment = new HomeFragment();
                        fragmentTransaction.replace(R.id.main_frameLayout, homeFragment).addToBackStack(null).commit();
                        return true;
                    case R.id.navigation_category:
                        Log.d("Click","Category");
                        CategoryFragment categoryFragment = new CategoryFragment();
                        fragmentTransaction.replace(R.id.main_frameLayout, categoryFragment).addToBackStack(null).commit();
                        return true;
                    case R.id.navigation_setting:
                        Log.d("Click","Setting");
                        SettingFragment settingFragment = new SettingFragment();
                        fragmentTransaction.replace(R.id.main_frameLayout, settingFragment).addToBackStack(null).commit();
                        return true;
                }
                return false;
            }
        });

    }

}
