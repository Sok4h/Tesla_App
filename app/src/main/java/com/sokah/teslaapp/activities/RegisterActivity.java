package com.sokah.teslaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.sokah.teslaapp.R;
import com.sokah.teslaapp.model.User;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout inputName,inputEmail,inputPassword,inputPassword2;
    Button btnRegister;
    FirebaseDatabase db;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputPassword2 = findViewById(R.id.inputRepeatPassword);
        btnRegister = findViewById(R.id.btnRegister);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        btnRegister.setOnClickListener(v->{

           Register();

        });


    }

    private void Register() {

        String name,email,password,repeatPassword;
        name=inputName.getEditText().getText().toString();
        email=inputEmail.getEditText().getText().toString();
        password=inputPassword.getEditText().getText().toString();
        repeatPassword=inputPassword2.getEditText().getText().toString();

        if(name.isEmpty()||email.isEmpty()||password.isEmpty()||repeatPassword.isEmpty()) {

            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
        }
        else{

            if(password.equals(repeatPassword)){

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task->{

                   if(task.isSuccessful()){

                       String id = task.getResult().getUser().getUid();

                       User user = new User(id,name,email);

                       db.getReference("users").child(id).setValue(user).addOnCompleteListener(register->{

                          if(register.isSuccessful()){

                              Toast.makeText(this, "registrado correctamente", Toast.LENGTH_SHORT).show();

                              Intent intent = new Intent(this,HomeActivity.class);
                              startActivity(intent);
                              finish();
                          }

                          else{

                              Toast.makeText(this, register.getException().getMessage(), Toast.LENGTH_SHORT).show();
                          }

                       });

                   }

                   else{

                       Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
                });

            }

            else{

                Toast.makeText(this, "Asegurese que ambas contraseñas coinciden", Toast.LENGTH_SHORT).show();
            }

        }
    }
}