package com.sokah.teslaapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sokah.teslaapp.R;
import com.sokah.teslaapp.model.Car;


public class CarFragment extends Fragment {



    public CarFragment() {
        // Required empty public constructor
    }


    public static CarFragment newInstance() {
        CarFragment fragment = new CarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    ImageView carImg;
    TextView carName,carSpeed,carWeight,carAceleration;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Gson gson = new Gson();
        String carString= getArguments().getString("car");
        Car car = gson.fromJson(carString, Car.class);

        View root =inflater.inflate(R.layout.fragment_car, container, false);
        carImg = root.findViewById(R.id.carImg);
        carName=root.findViewById(R.id.carName);
        carSpeed=root.findViewById(R.id.tvSpeed);
        carAceleration=root.findViewById(R.id.tvAceleration);
        carWeight = root.findViewById(R.id.tvWeight);

        if(car!=null) {
            Glide.with(this).load(car.getImgUrl()).centerCrop().into(carImg);
            carName.setText(car.getName());
            carSpeed.setText(String.valueOf(car.getSpeed()));
            carAceleration.setText(String.valueOf(car.getAceleration()));
            carWeight.setText(String.valueOf(car.getWeight()));
        }

        return root;
    }



}