package com.sokah.teslaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.sokah.teslaapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin,btnRegister;
    Intent intent;

    public static MainActivity instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        btnLogin =  findViewById(R.id.btnLoginMain);
        btnRegister = findViewById(R.id.btnRegisterMain);

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {


            case R.id.btnLoginMain:

                intent= new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.btnRegisterMain:
                 intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }


}