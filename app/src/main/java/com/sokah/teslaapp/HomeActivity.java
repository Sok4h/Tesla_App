package com.sokah.teslaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private HomeFragment homeFragment;

    private ProfileFragment profileFragment;

    BottomNavigationView navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigator = findViewById(R.id.navigator);

        homeFragment = HomeFragment.newInstance();
        profileFragment = ProfileFragment.newInstance();
        ShowFragment(homeFragment);

        navigator.setOnNavigationItemSelectedListener(menuItem -> {

            switch (menuItem.getItemId()) {

                case R.id.home:

                    ShowFragment(homeFragment);
                    break;

                case R.id.profile:

                    ShowFragment(profileFragment);
                    break;

            }

            return true;
        });
    }


    public void ShowFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();


    }
}