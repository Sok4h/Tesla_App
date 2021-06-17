package com.sokah.teslaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sokah.teslaapp.R;
import com.sokah.teslaapp.activities.MainActivity;

public class SplashActivity extends AppCompatActivity {


    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        auth = FirebaseAuth.getInstance();

        auth.addAuthStateListener(firebaseAuth -> {

            user= firebaseAuth.getCurrentUser();
            ChangeActivity();

        });

    }

    private void ChangeActivity(){

        Handler handler = new Handler();

        handler.postDelayed(() -> {

            if(user != null){

                Intent intent = new Intent(this,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
            if(user==null){
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }


        },2000);
    }
}