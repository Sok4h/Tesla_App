package com.sokah.teslaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.UUID;

public class CarAdapter extends RecyclerView.Adapter<CarView> {

    private ArrayList<Car> carArrayList;
    private ViewGroup group;

    public CarAdapter() {
        carArrayList = new ArrayList<>();
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Roadster","4 years","https://mychiptuningfiles.com/es/image/models/YEdPJDTEJGtIpmJUdcezezZIfZtG5p.png"
        ,10f,20f));
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Model S","3 years","https://mychiptuningfiles.com/es/image/models/WtTSLioiY4XAUC2lBWLHlhzr6hEYbN.png"
                ,20f,50f));
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Roadster","4 years","https://mychiptuningfiles.com/es/image/models/YEdPJDTEJGtIpmJUdcezezZIfZtG5p.png"
                ,10f,20f));
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Roadster","4 years","https://mychiptuningfiles.com/es/image/models/YEdPJDTEJGtIpmJUdcezezZIfZtG5p.png"
                ,10f,20f));
        carArrayList.add(new Car(UUID.randomUUID().toString(),"Roadster","4 years","https://mychiptuningfiles.com/es/image/models/YEdPJDTEJGtIpmJUdcezezZIfZtG5p.png"
                ,10f,20f));
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
