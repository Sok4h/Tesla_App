package com.sokah.teslaapp.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sokah.teslaapp.fragments.CarFragment;
import com.sokah.teslaapp.fragments.HomeFragment;
import com.sokah.teslaapp.model.CarView;
import com.sokah.teslaapp.R;
import com.sokah.teslaapp.model.Car;

import java.util.ArrayList;
import java.util.UUID;

public class CarAdapter extends RecyclerView.Adapter<CarView> {

    private ArrayList<Car> carArrayList;
    private ViewGroup group;
    private CarFragment carFragment;

    public CarAdapter() {

        carFragment = CarFragment.newInstance();
        carArrayList = new ArrayList<>();
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Roadster","4 years","https://mychiptuningfiles.com/es/image/models/YEdPJDTEJGtIpmJUdcezezZIfZtG5p.png"
        ,10,20,3,100));
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Model S","3 years","https://mychiptuningfiles.com/es/image/models/WtTSLioiY4XAUC2lBWLHlhzr6hEYbN.png"
                ,20,50,2,120));
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Roadster","4 years","https://mychiptuningfiles.com/es/image/models/YEdPJDTEJGtIpmJUdcezezZIfZtG5p.png"
                ,10,20,1,120));
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Roadster","4 years","https://mychiptuningfiles.com/es/image/models/YEdPJDTEJGtIpmJUdcezezZIfZtG5p.png"
                ,10,20,8,200));
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Roadster","4 years","https://mychiptuningfiles.com/es/image/models/YEdPJDTEJGtIpmJUdcezezZIfZtG5p.png"
                ,10,20,6,10));
    }




    public void AddCar(Car car) {

        carArrayList.add(car);
    }


    @Override
    public CarView onCreateViewHolder(ViewGroup parent, int viewType) {
        group=parent;
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View row = layoutInflater.inflate(R.layout.car_item,parent,false);
        ConstraintLayout rowRoot = (ConstraintLayout) row;
        CarView carView = new CarView(rowRoot);

        return carView;
    }

    @Override
    public void onBindViewHolder(CarView holder, int position) {

        holder.getTvCarName().setText(carArrayList.get(position).getName());
        holder.getTvCarPrice().setText(String.valueOf(carArrayList.get(position).getPrice()));
        holder.getTvCarWaranty().setText(carArrayList.get(position).getWaranty());
        holder.getBtnBuy().setOnClickListener(v->{
           Toast.makeText(group.getContext(),"comprando " + carArrayList.get(position).getName(),Toast.LENGTH_SHORT).show();

        });
        holder.getRoot().setOnClickListener(v->{
            Gson gson= new Gson();
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            String car =gson.toJson(carArrayList.get(position));
            Bundle bundle = new Bundle();
            bundle.putString("car", car);
            carFragment.setArguments(bundle);
            transaction.replace(R.id.fragmentContainer, carFragment);
            transaction.commit();

        });
        Glide.with(group.getContext())
                .load(carArrayList.get(position).getImgUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.getCarImage());
    }

    @Override
    public int getItemCount() {
        return carArrayList.size();
    }
}
