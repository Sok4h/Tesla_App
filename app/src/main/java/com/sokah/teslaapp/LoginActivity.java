package com.sokah.teslaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin =  findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v->{

           Intent intent = new Intent(this, HomeActivity.class);
           startActivity(intent);

        });
    }
}