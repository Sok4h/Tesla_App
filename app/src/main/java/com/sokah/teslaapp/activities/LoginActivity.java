package com.sokah.teslaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.sokah.teslaapp.R;
import com.sokah.teslaapp.activities.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin ;
    TextInputLayout email,password;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin =  findViewById(R.id.btnLogin);
        auth=FirebaseAuth.getInstance();
        email = findViewById(R.id.inputEmailLogin);
        password = findViewById(R.id.inputPasswordLogin);

        btnLogin.setOnClickListener(v->{

            auth.signInWithEmailAndPassword(email.getEditText().getText().toString(),password.getEditText().getText().toString()).addOnCompleteListener(

                    task->{

                        if(task.isSuccessful()){

                            Intent intent = new Intent(this,HomeActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                            finish();
                        }

                        else{

                            Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
            );


        });
    }
}