package com.sokah.teslaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin,btnRegister;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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