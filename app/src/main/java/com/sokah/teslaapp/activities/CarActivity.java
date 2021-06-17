package com.sokah.teslaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sokah.teslaapp.R;
import com.sokah.teslaapp.model.Car;

public class CarActivity extends AppCompatActivity {

    ImageView carImg;
    TextView carName,carSpeed,carWeight,carAceleration,carPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);


        Gson gson = new Gson();
        String carString= getIntent().getStringExtra("car");
        Car car = gson.fromJson(carString, Car.class);


        carImg = findViewById(R.id.carImg);
        carName=findViewById(R.id.carName);
        carSpeed=findViewById(R.id.tvSpeed);
        carPrice = findViewById(R.id.carPrice);
        carAceleration=findViewById(R.id.tvAceleration);
        carWeight = findViewById(R.id.tvWeight);

        if(car!=null) {
            Glide.with(this).load(car.getImgUrl()).centerCrop().into(carImg);
            carName.setText(car.getName());
            carSpeed.setText(String.valueOf(car.getSpeed()));
            carAceleration.setText(String.valueOf(car.getAceleration()));
            carWeight.setText(String.valueOf(car.getWeight()));
            carPrice.setText(String.valueOf(car.getPrice()));
        }
    }
}