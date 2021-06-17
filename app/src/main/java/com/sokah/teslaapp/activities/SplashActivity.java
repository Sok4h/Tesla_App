package com.sokah.teslaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.sokah.teslaapp.R;
import com.sokah.teslaapp.activities.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       Handler handler = new Handler();

       handler.postDelayed(() -> {

           Intent intent = new Intent(this, MainActivity.class);
           startActivity(intent);
           finish();

       },2000);
    }
}